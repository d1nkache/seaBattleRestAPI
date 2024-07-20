package quizbackend.seaBattleApi.restAPI.model.messages

import org.springframework.http.HttpStatus

abstract class AbstractMessage: ApiResponse {
    override val status: HttpStatus = HttpStatus.OK
}