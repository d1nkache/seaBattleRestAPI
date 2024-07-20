package quizbackend.seaBattleApi.restAPI.controller

import quizbackend.seaBattleApi.restAPI.model.messages.HealthStateMessage

interface HealthController {
    fun getServerStatus(): HealthStateMessage
}