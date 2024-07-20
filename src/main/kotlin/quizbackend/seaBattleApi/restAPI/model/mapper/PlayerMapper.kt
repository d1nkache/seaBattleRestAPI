package quizbackend.seaBattleApi.restAPI.model.mapper

import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.restAPI.database.PlayerEntity
import quizbackend.seaBattleApi.restAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.restAPI.model.response.PlayerResponse
import java.time.LocalDateTime
import java.util.*


@Component
class PlayerMapper {
    fun asResponse(request: PlayerRequest, playerId: Long, createdAt: LocalDateTime): PlayerResponse = PlayerResponse(
            id = playerId,
            createdAt = createdAt,
            name = request.name,
            state = request.state,
            health = request.health,
            status = request.status
        )

    fun asEntity(entity: Optional<PlayerEntity>): PlayerEntity = PlayerEntity(
        name = entity.orElseThrow {
            IllegalArgumentException("Entity cannot be empty")
        }.name,
        state = entity.orElseThrow {
            IllegalArgumentException("Entity cannot be empty")
        }.state,
        health = entity.orElseThrow {
            IllegalArgumentException("Entity cannot be empty")
        }.health,
        status = entity.orElseThrow {
            IllegalArgumentException("Entity cannot be empty")
        }.status
    )
}