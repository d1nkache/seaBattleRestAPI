package quizbackend.seaBattleApi.restAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import quizbackend.seaBattleApi.restAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

@Entity
@Table(name = "Player")
class PlayerEntity(
    @Column(nullable = false, updatable = true)
    var name: String,

    @Column(nullable = false, updatable = true)
    var state: PlayerState,

    @Column(nullable = false, updatable = true)
    var health: Int,

    @Column(nullable = false, updatable = true)
    var status: PlayerStatus

): AbstractEntity()