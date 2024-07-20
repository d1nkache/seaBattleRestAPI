package quizbackend.seaBattleApi.restAPI.service

interface MainMenuService {
    fun initGame(userId: Long, gameId: Long): Any
    fun chooseOnlineGame(userId: Long, gameId: Long): Any
    fun chooseOfflineGame(userId: Long, gameId: Long): Any
    fun reconnect(userId: Long, gameId: Long): Any
}