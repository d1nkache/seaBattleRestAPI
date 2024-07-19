package quizbackend.seaBattleApi.RestAPI.controller

import quizbackend.seaBattleApi.RestAPI.model.messages.HealthStateMessage

interface HealthController {
    fun getServerStatus(): HealthStateMessage
}