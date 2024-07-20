package quizbackend.seaBattleApi.restAPI.model.request

import quizbackend.seaBattleApi.restAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

class PlayerRequest (
    val name: String,
    val state: PlayerState,
    val health: Int,
    val status: PlayerStatus
)
