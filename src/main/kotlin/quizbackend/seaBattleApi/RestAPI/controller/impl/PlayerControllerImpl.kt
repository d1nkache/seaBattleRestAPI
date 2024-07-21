package quizbackend.seaBattleApi.RestAPI.controller.impl

import org.springframework.web.bind.annotation.*
import quizbackend.seaBattleApi.RestAPI.controller.PlayerController
import quizbackend.seaBattleApi.RestAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.RestAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.RestAPI.model.response.PlayerResponse
import quizbackend.seaBattleApi.RestAPI.service.PlayerService

@RestController
@RequestMapping("/api")
class PlayerControllerImpl(
    private val service: PlayerService
) : PlayerController {
    @PostMapping("/createPlayer")
    override fun createPlayer(@RequestBody request: PlayerRequest): PlayerResponse = service.createPlayer(request)

    @GetMapping("/getPlayer/{userId}")
    override fun getUserById(@PathVariable userId: Long): PlayerResponse = service.getUserById(userId)

    @GetMapping("/getAllUsers")
    override fun getAllUsers(): List<PlayerResponse> = service.getAllUsers()

    @DeleteMapping("/deletePlayer/{userId}")
    override fun deleteUserById(@PathVariable userId: Long): DeleteMessage = service.deleteUserById(userId)
}