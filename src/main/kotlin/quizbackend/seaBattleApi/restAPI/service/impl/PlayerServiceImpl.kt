package quizbackend.seaBattleApi.restAPI.service.impl

import quizbackend.seaBattleApi.restAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.restAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse
import quizbackend.seaBattleApi.restAPI.service.PlayerService

class PlayerServiceImpl(
    mapper: PlayerMapper
) : PlayerService {
    override fun createPlayer(request: PlayerRequest): PlayerResponse {

    }

    override fun getUserById(userId: Int): PlayerResponse {

    }

    override fun getAllUsers(): List<PlayerResponse> {

    }

    override fun deleteUserById(userId: Int): DeleteMessage {

    }
}