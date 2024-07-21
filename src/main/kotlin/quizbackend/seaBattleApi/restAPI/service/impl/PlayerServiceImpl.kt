package quizbackend.seaBattleApi.restAPI.service.impl

import org.springframework.stereotype.Service
import quizbackend.seaBattleApi.restAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.restAPI.model.mapper.PlayerMapper
import quizbackend.seaBattleApi.restAPI.model.messages.DeleteMessage
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse
import quizbackend.seaBattleApi.restAPI.service.PlayerService

@Service
class PlayerServiceImpl(
    private val mapper: PlayerMapper,
    private val dao: PlayerDao
) : PlayerService {
    override fun createPlayer(request: PlayerRequest): PlayerResponse {
        val newPlayer = mapper.asEntityFromRequest(request).also {
            dao.save(it)
        }

        return mapper.asResponse(newPlayer)
    }

    override fun getUserById(userId: Long): PlayerResponse {
        return mapper.asResponse(dao.findPlayerEntityById(userId))
    }

    override fun getAllUsers(): List<PlayerResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteUserById(userId: Long): DeleteMessage {
        val player = dao.findPlayerEntityById(userId)
        dao.delete(player)

        return DeleteMessage()
    }
}