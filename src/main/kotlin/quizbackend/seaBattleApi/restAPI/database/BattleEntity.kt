package quizbackend.seaBattleApi.restAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import quizbackend.seaBattleApi.restAPI.database.entityHelper.BattleStatus

@Entity
@Table(name = "Battle")
class BattleEntity(
    @Column(nullable = false, updatable = true)
    var countOfRounds: Int,

    @Column(nullable = false, updatable = true)
    var status: BattleStatus,

    @OneToMany
    var players: List<PlayerEntity> = mutableListOf()
):AbstractEntity()