package quizbackend.seaBattleApi.RestAPI.model.messages

import org.springframework.http.HttpStatus

interface ApiResponse {
    val status: HttpStatus
    val message: String
}