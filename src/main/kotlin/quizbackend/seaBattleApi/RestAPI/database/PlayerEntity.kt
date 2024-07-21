package quizbackend.seaBattleApi.RestAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import quizbackend.seaBattleApi.RestAPI.database.entityHelper.PlayerStatus
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

@Entity
class PlayerEntity(
    @Column(nullable = false, updatable = true)
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = true)
    var state: PlayerState,

    @Column(nullable = true, updatable = true)
    var health: Int,

    @Column(nullable = true, updatable = true)
    var status: PlayerStatus

): AbstractEntity()