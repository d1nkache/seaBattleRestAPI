package quizbackend.seaBattleApi.restAPI.model.mapper

import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.restAPI.database.GameEntity
import java.util.*

@Component
class GameMapper {
    fun asEntity(entity: Optional<GameEntity>): GameEntity = GameEntity(
        state = entity.orElseThrow{
            IllegalArgumentException("Entity cannot be empty")
        }.state
    )
}