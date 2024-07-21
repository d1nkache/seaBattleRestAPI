package quizbackend.seaBattleApi.RestAPI.model.mapper

import org.springframework.stereotype.Component
import quizbackend.seaBattleApi.RestAPI.database.GameEntity
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState
import java.util.*

@Component
class GameMapper {
    fun asEntityFromGameState(gameState: GameState): GameEntity = GameEntity(
        state = gameState
    )

    fun asEntity(entity: Optional<GameEntity>): GameEntity = GameEntity(
        state = entity.orElseThrow{
            IllegalArgumentException("Entity cannot be empty")
        }.state
    )
}