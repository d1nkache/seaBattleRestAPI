package quizbackend.seaBattleApi.restAPI.controller.impl

import org.springframework.web.bind.annotation.*
import quizbackend.seaBattleApi.restAPI.controller.MainMenuController
import quizbackend.seaBattleApi.restAPI.service.MainMenuService

@RestController
@RequestMapping("/api")
class MainMenuControllerImpl(
    private val service: MainMenuService
) : MainMenuController {
    @PostMapping("/init/{userId}/{gameId}")
    override fun initGameEvent(@PathVariable userId: Long, @PathVariable gameId: Long) = service.initGame(userId, gameId)

    @PostMapping("/playOnline")
    override fun chooseOnlineGameEvent(userId: Long) = service.chooseOnlineGame(userId)

    @PostMapping("/playOffline")
    override fun chooseOfflineGameEvent(userId: Long) = service.chooseOfflineGame(userId)

    @PostMapping("/reconnect")
    override fun reconnectEvent(userId: Long) = service.reconnect(userId)
}