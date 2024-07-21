package quizbackend.seaBattleApi.RestAPI.model.request

import quizbackend.seaBattleApi.RestAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

class PlayerRequest (
    val name: String,
    val state: PlayerState = PlayerState.NOT_INIT,
    val health: Int = 0,
    val status: PlayerStatus = PlayerStatus.ONLINE
)
