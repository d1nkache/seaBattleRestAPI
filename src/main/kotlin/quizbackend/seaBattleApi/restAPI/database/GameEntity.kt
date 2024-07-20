package quizbackend.seaBattleApi.restAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState

@Entity
@Table(name = "Game")
class GameEntity(
    @Column(nullable = false, updatable = true)
    var state: GameState
): AbstractEntity()