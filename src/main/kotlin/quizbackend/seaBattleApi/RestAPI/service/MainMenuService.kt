package quizbackend.seaBattleApi.RestAPI.service

interface MainMenuService {
    fun initGame(): Any
    fun chooseOnlineGame(userId: Long): Any
    fun chooseOfflineGame(userId: Long): Any
    fun reconnect(userId: Long): Any
}