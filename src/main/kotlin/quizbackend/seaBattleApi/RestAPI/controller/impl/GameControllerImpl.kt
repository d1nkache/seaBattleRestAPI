package quizbackend.seaBattleApi.RestAPI.controller.impl

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import quizbackend.seaBattleApi.RestAPI.controller.GameController
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.model.messages.DeleteMessage


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ВЫНЕСИ В СЕРВИС ЛОГИКУ НЕ ЛЕНИСЬ
@RestController
class GameControllerImpl(
    private val gameDao: GameDao,
    dao: GameDao
) : GameController {
    @DeleteMapping("/api/deleteGame/{gameId}")
    override fun deleteGame(@PathVariable gameId: Long): Any {
        gameDao.deleteById(gameId)

        return DeleteMessage()
    }
}