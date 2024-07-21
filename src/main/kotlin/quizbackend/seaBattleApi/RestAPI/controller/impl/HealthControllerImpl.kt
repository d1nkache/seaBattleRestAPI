package quizbackend.seaBattleApi.RestAPI.controller.impl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import quizbackend.seaBattleApi.RestAPI.controller.HealthController
import quizbackend.seaBattleApi.RestAPI.model.messages.HealthStateMessage

@RestController
class HealthControllerImpl: HealthController {
    @GetMapping("/api/health")
    override fun getServerStatus(): HealthStateMessage = HealthStateMessage()
}