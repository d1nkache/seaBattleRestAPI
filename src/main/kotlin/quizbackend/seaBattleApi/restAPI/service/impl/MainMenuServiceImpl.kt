package quizbackend.seaBattleApi.restAPI.service.impl

import org.springframework.stereotype.Service
import quizbackend.seaBattleApi.restAPI.database.dao.GameDao
import quizbackend.seaBattleApi.restAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.restAPI.model.mapper.GameMapper
import quizbackend.seaBattleApi.restAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.restAPI.model.response.TransitionResponse
import quizbackend.seaBattleApi.restAPI.service.MainMenuService
import quizbackend.seaBattleApi.restAPI.service.helpers.helpMakeTransition
import quizbackend.seaBattleApi.stateMachine.StateMachine
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*


@Service
class MainMenuServiceImpl(
    private val playerMapper: PlayerMapper,
    private val gameMapper: GameMapper,
    private val playerDao: PlayerDao,
    private val gameDao: GameDao
) : MainMenuService {
    val stateMachineObject = StateMachine(playerDao, gameDao)

    override fun initGame(userId: Long, gameId: Long): TransitionResponse = helpMakeTransition(
        userId,
        gameId,
        PlayerEvent.INIT,
        PlayerState.NOT_INIT,
        GameState.NOT_INIT,
        playerMapper,
        gameMapper,
        playerDao,
        gameDao,
        stateMachineObject
    )


    override fun chooseOnlineGame(userId: Long, gameId: Long): TransitionResponse = helpMakeTransition(
        userId,
        gameId,
        PlayerEvent.CHOOSE_ONLINE_GAME,
        PlayerState.IN_MENU,
        GameState.MAIN_MENU,
        playerMapper,
        gameMapper,
        playerDao,
        gameDao,
        stateMachineObject
    )

    override fun chooseOfflineGame(userId: Long, gameId: Long) = helpMakeTransition(
        userId,
        gameId,
        PlayerEvent.CHOOSE_OFFLINE_GAME,
        PlayerState.IN_MENU,
        GameState.MAIN_MENU,
        playerMapper,
        gameMapper,
        playerDao,
        gameDao,
        stateMachineObject
    )

    override fun reconnect(userId: Long, gameId: Long): Any {
        TODO("Not yet implemented")
    }
}