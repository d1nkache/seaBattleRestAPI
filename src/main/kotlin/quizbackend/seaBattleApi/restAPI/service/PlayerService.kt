package quizbackend.seaBattleApi.restAPI.service

import quizbackend.seaBattleApi.restAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse

interface PlayerService {
    fun createPlayer(request: PlayerRequest): PlayerResponse
    fun getUserById(userId: Int): PlayerResponse
    fun getAllUsers(): List<PlayerResponse>
    fun deleteUserById(userId: Int): DeleteMessage
}