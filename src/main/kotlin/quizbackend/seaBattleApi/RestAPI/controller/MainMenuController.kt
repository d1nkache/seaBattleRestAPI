package quizbackend.seaBattleApi.RestAPI.controller

interface MainMenuController {
    fun initGameEvent(userId: Long): Any
    fun chooseOnlineGameEvent(userId: Long, gameId: Long): Any
    fun chooseOfflineGameEvent(userId: Long, gameId: Long): Any
    fun reconnectEvent(userId: Long, gameId: Long): Any
}