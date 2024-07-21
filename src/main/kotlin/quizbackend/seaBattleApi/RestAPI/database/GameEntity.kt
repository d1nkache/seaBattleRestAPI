package quizbackend.seaBattleApi.RestAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState

@Entity
class GameEntity(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = true)
    var state: GameState
): AbstractEntity()