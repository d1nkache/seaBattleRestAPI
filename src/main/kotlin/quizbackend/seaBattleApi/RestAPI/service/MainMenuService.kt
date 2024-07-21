package quizbackend.seaBattleApi.RestAPI.service

interface MainMenuService {
    fun initGame(userId: Long): Any
    fun chooseOnlineGame(userId: Long, gameId: Long): Any
    fun chooseOfflineGame(userId: Long, gameId: Long): Any
    fun reconnect(userId: Long, gameId: Long): Any
}