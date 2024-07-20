package quizbackend.seaBattleApi.restAPI.service.impl

import org.springframework.stereotype.Service
import quizbackend.seaBattleApi.restAPI.database.dao.GameDao
import quizbackend.seaBattleApi.restAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.restAPI.model.mapper.GameMapper
import quizbackend.seaBattleApi.restAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.restAPI.model.response.TransitionResponse
import quizbackend.seaBattleApi.restAPI.service.MainMenuService
import quizbackend.seaBattleApi.stateMachine.StateMachine
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*
import quizbackend.seaBattleApi.stateMachine.transitions.GameTransition
import quizbackend.seaBattleApi.stateMachine.transitions.PlayerTransition

@Service
class MainMenuServiceImpl(
    private val stateMachine: StateMachine,
    private val playerMapper: PlayerMapper,
    private val gameMapper: GameMapper,
    private val playerDao: PlayerDao,
    private val gameDao: GameDao
) : MainMenuService {
    val stateMachineObject = StateMachine(playerDao, gameDao)

    override fun initGame(userId: Long, gameId: Long): TransitionResponse {
        val transitionResponse = TransitionResponse(mutableMapOf())
        val currentPlayerTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.INIT), PlayerState.NOT_INIT, PlayerTransition.allPlayerTransitions)
        val currentGameTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.INIT), GameState.NOT_INIT, GameTransition.allGameTransitions)
        val currentPlayer = playerMapper.asEntity(playerDao.findById(userId))
        val currentGame = gameMapper.asEntity(gameDao.findById(gameId))

        if (currentPlayerTransition != null) {
            if (currentGameTransition != null) {
                if (currentPlayer.state == currentPlayerTransition.currentState && currentGame.state == currentGameTransition.currentState) {
                    stateMachineObject.handleEvent(
                        Event.EventsOfPlayer(PlayerEvent.INIT),
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

    override fun chooseOnlineGame(userId: Long, gameId: Long): Any {
        val transitionResponse = TransitionResponse(mutableMapOf())
        val currentPlayerTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME), PlayerState.IN_MENU, PlayerTransition.allPlayerTransitions)
        val currentGameTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME), GameState.MAIN_MENU, GameTransition.allGameTransitions)
        val currentPlayer = playerMapper.asEntity(playerDao.findById(userId))
        val currentGame = gameMapper.asEntity(gameDao.findById(gameId))

        if (currentPlayerTransition != null) {
            if (currentGameTransition != null) {
                if (currentPlayer.state == currentPlayerTransition.currentState && currentGame.state == currentGameTransition.currentState) {
                    stateMachineObject.handleEvent(
                        Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME),
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

    override fun chooseOfflineGame(userId: Long, gameId: Long): Any {
        val transitionResponse = TransitionResponse(mutableMapOf())
        val currentPlayerTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.CHOOSE_OFFLINE_GAME), PlayerState.IN_MENU, PlayerTransition.allPlayerTransitions)
        val currentGameTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.CHOOSE_OFFLINE_GAME), GameState.MAIN_MENU, GameTransition.allGameTransitions)
        val currentPlayer = playerMapper.asEntity(playerDao.findById(userId))
        val currentGame = gameMapper.asEntity(gameDao.findById(gameId))

        if (currentPlayerTransition != null) {
            if (currentGameTransition != null) {
                if (currentPlayer.state == currentPlayerTransition.currentState && currentGame.state == currentGameTransition.currentState) {
                    stateMachineObject.handleEvent(
                        Event.EventsOfPlayer(PlayerEvent.INIT),
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

    override fun reconnect(userId: Long, gameId: Long): Any {
        TODO("Not yet implemented")
    }
}