package quizbackend.seaBattleApi.RestAPI.model.mapper

import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.RestAPI.database.GameEntity
import java.util.*

@Component
class GameMapper {
    fun asEntity(entity: Optional<GameEntity>): GameEntity = GameEntity(
        state = entity.orElseThrow{
            IllegalArgumentException("Entity cannot be empty")
        }.state
    )
}