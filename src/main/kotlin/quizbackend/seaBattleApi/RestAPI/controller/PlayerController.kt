package quizbackend.seaBattleApi.RestAPI.controller

import quizbackend.seaBattleApi.RestAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.RestAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.RestAPI.model.response.PlayerResponse

interface PlayerController {
    fun createPlayer(request: PlayerRequest): PlayerResponse
    fun getUserById(userId: Long): PlayerResponse
    fun getAllUsers(): List<PlayerResponse>
    fun deleteUserById(userId: Long): DeleteMessage
}