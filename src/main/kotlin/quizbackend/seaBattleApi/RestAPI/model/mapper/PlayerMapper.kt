package quizbackend.seaBattleApi.RestAPI.model.mapper

import jakarta.persistence.Column
import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity
import quizbackend.seaBattleApi.RestAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.RestAPI.model.response.PlayerResponse
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerEvent
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState
import java.time.LocalDateTime
import java.util.*


@Component
class PlayerMapper {
    fun asResponse(
        id: Long,
        createdAt: LocalDateTime,
        name: String,
        state: PlayerState,
        health: Int,
        status: PlayerStatus
    ): PlayerResponse = PlayerResponse(
            id = id,
            createdAt = createdAt,
            name = name,
            state = state,
            health = health,
            status = status
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