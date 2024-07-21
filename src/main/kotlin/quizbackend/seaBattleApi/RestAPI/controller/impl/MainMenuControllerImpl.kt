package quizbackend.seaBattleApi.RestAPI.controller.impl

import org.springframework.web.bind.annotation.*
import quizbackend.seaBattleApi.RestAPI.controller.MainMenuController
import quizbackend.seaBattleApi.RestAPI.service.MainMenuService

@RestController
@RequestMapping("/api")
class MainMenuControllerImpl(
    private val service: MainMenuService
) : MainMenuController {
    @PostMapping("/init/{userId}")
    override fun initGameEvent(@PathVariable userId: Long) = service.initGame(userId)

    @PostMapping("/playOnline")
    override fun chooseOnlineGameEvent(userId: Long, gameId: Long) = service.chooseOnlineGame(userId, gameId)

    @PostMapping("/playOffline")
    override fun chooseOfflineGameEvent(userId: Long, gameId: Long) = service.chooseOfflineGame(userId, gameId)

    @PostMapping("/reconnect")
    override fun reconnectEvent(userId: Long, gameId: Long) = service.reconnect(userId, gameId)
}