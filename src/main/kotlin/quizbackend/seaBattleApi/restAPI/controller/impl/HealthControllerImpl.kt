package quizbackend.seaBattleApi.restAPI.controller.impl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import quizbackend.seaBattleApi.restAPI.controller.HealthController
import quizbackend.seaBattleApi.restAPI.model.messages.HealthStateMessage

@RestController
class HealthControllerImpl: HealthController {
    @GetMapping("/api/health")
    override fun getServerStatus(): HealthStateMessage = HealthStateMessage()
}