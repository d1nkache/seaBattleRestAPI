package quizbackend.seaBattleApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import quizbackend.seaBattleApi.RestAPI.service.impl.MainMenuServiceImpl
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.Event
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerEvent

@SpringBootApplication
class SeaBattleRestApiApplication

fun main(args: Array<String>) {
    runApplication<SeaBattleRestApiApplication>(*args)
}
