package quizbackend.seaBattleApi.RestAPI.model.mapper

import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity
import quizbackend.seaBattleApi.RestAPI.model.request.PlayerRequest
import quizbackend.seaBattleApi.RestAPI.model.response.PlayerResponse
import java.util.*


@Component
class PlayerMapper {
    fun asResponse(entity: PlayerEntity): PlayerResponse = PlayerResponse(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name,
            state = entity.state,
            health = entity.health,
            status = entity.status
        )

    fun asEntityFromRequest(request: PlayerRequest): PlayerEntity = PlayerEntity(
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