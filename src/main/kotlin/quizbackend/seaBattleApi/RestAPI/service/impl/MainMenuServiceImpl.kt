package quizbackend.seaBattleApi.RestAPI.service.impl

import org.springframework.stereotype.Service
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.RestAPI.model.mapper.GameMapper
import quizbackend.seaBattleApi.RestAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.RestAPI.service.MainMenuService
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

    override fun initGame(userId: Long, gameId: Long): Any {
        val currentPlayerTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.INIT), PlayerState.NOT_INIT, PlayerTransition.allPlayerTransitions)
        val currentGameTransition = stateMachineObject.findTransition(Event.EventsOfPlayer(PlayerEvent.INIT), GameState.NOT_INIT, GameTransition.allGameTransitions)
        val currentPlayer = playerMapper.asEntity(playerDao.findById(userId))
        val currentGame = gameMapper.asEntity(gameDao.findById(gameId))

        stateMachineObject.handleEvent(
            Event.EventsOfPlayer(PlayerEvent.INIT),
            currentPlayer,
            currentGame,
            currentPlayerTransition,
            currentGameTransition
        )

        return ""
    }

    override fun chooseOnlineGame(userId: Long): Any {
        TODO("Not yet implemented")
    }

    override fun chooseOfflineGame(userId: Long): Any {
        TODO("Not yet implemented")
    }

    override fun reconnect(userId: Long): Any {
        TODO("Not yet implemented")
    }
}