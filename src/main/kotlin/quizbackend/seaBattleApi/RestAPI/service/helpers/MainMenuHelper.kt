package quizbackend.seaBattleApi.RestAPI.service.helpers

import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.RestAPI.model.mapper.GameMapper
import quizbackend.seaBattleApi.RestAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.RestAPI.model.response.TransitionResponse
import quizbackend.seaBattleApi.stateMachine.StateMachine
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*
import quizbackend.seaBattleApi.stateMachine.transitions.GameTransition
import quizbackend.seaBattleApi.stateMachine.transitions.PlayerTransition


@Modifying
@Transactional
fun helpMakeTransition(
    userId: Long,
    gameId: Long,
    playerEvent: PlayerEvent,
    playerState: PlayerState,
    gameState: GameState,
    playerMapper: PlayerMapper,
    gameMapper: GameMapper,
    playerDao: PlayerDao,
    gameDao: GameDao,
    stateMachineObject: StateMachine
): TransitionResponse {
    val transitionResponse = TransitionResponse(mutableMapOf())
    val currentPlayerTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(playerEvent), playerState, PlayerTransition.allPlayerTransitions)
    val currentGameTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(playerEvent), gameState, GameTransition.allGameTransitions)
    val currentPlayer = playerMapper.asEntity(playerDao.findById(userId))
    val currentGame = gameMapper.asEntity(gameDao.findById(gameId))

    if (currentPlayerTransition != null) {
        if (currentGameTransition != null) {
            if (currentPlayer.state == currentPlayerTransition.currentState && currentGame.state == currentGameTransition.currentState) {
                stateMachineObject.handleEvent(
                    Event.EventsOfPlayer(playerEvent),
                    currentPlayer,
                    currentGame,
                    currentPlayerTransition,
                    currentGameTransition,
                    transitionResponse
                )

                return transitionResponse
            }
        }
    }

    transitionResponse.map["Error"] = "No such Transition"

    return transitionResponse
}