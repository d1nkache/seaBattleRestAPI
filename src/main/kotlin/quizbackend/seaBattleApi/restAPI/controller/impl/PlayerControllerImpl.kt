package quizbackend.seaBattleApi.restAPI.controller.impl

import quizbackend.seaBattleApi.restAPI.controller.PlayerController
import quizbackend.seaBattleApi.restAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse

class PlayerControllerImpl(
    private val service PlayerService
) : PlayerController {
    override fun createPlayer(request: PlayerRequest): PlayerResponse = service.createPlayer(request)
    override fun getUserById(userId: Int): PlayerResponse = service.getUserById(userId)
    override fun getAllUsers(): List<PlayerResponse> = service.getAllUsers()
    override fun deleteUserById(userId: Int): DeleteMessage = service.deleteUserById(userId)
}