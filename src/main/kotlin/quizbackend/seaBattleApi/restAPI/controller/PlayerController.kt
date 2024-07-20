package quizbackend.seaBattleApi.restAPI.controller

import quizbackend.seaBattleApi.restAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse

interface PlayerController {
    fun createPlayer(request: PlayerRequest): PlayerResponse
    fun getUserById(userId: Int): PlayerResponse
    fun getAllUsers(): List<PlayerResponse>
    fun deleteUserById(userId: Int): DeleteMessage
}



//@Column(nullable = false, updatable = true)
//var name: String,
//
//@Column(nullable = false, updatable = true)
//var state: PlayerState,
//
//@Column(nullable = false, updatable = true)
//var health: Int,
//
//@Column(nullable = false, updatable = true)
//var status: PlayerStatus