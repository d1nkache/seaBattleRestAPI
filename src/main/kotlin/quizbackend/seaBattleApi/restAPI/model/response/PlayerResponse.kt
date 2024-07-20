package quizbackend.seaBattleApi.restAPI.model.response

import quizbackend.seaBattleApi.restAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState
import java.time.LocalDateTime

class PlayerResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val name: String,
    val state: PlayerState,
    val health: Int,
    val status: PlayerStatus
)