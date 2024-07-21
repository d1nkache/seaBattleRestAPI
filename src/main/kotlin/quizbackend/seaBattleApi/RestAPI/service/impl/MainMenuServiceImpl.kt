package quizbackend.seaBattleApi.RestAPI.service.impl

import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.RestAPI.model.mapper.GameMapper
import quizbackend.seaBattleApi.RestAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.RestAPI.model.response.TransitionResponse
import quizbackend.seaBattleApi.RestAPI.service.MainMenuService
import quizbackend.seaBattleApi.RestAPI.service.helpers.helpMakeTransition
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

    @Transactional
    @Modifying
    override fun initGame(userId: Long): TransitionResponse {
        val newGame = gameDao.save(gameMapper.asEntityFromGameState(GameState.NOT_INIT))

        return helpMakeTransition(
            userId,
            newGame.id,
            PlayerEvent.INIT,
            PlayerState.NOT_INIT,
            GameState.NOT_INIT,
            playerMapper,
            gameMapper,
            playerDao,
            gameDao,
            stateMachineObject
        )
    }



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