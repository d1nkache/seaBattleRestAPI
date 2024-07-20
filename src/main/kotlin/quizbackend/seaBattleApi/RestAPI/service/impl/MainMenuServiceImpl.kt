package quizbackend.seaBattleApi.RestAPI.service.impl

import org.springframework.stereotype.Service
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.RestAPI.service.MainMenuService
import quizbackend.seaBattleApi.stateMachine.StateMachine

@Service
class MainMenuServiceImpl(
    private val stateMachine: StateMachine
) : MainMenuService {
    override fun initGame(): Any {

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