package quizbackend.seaBattleApi.restAPI.controller

interface MainMenuController {
    fun initGameEvent(userId: Long, gameId: Long): Any
    fun chooseOnlineGameEvent(userId: Long): Any
    fun chooseOfflineGameEvent(userId: Long): Any
    fun reconnectEvent(userId: Long): Any
}