package quizbackend.seaBattleApi.RestAPI.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import quizbackend.seaBattleApi.RestAPI.database.entityHelper.BattleStatus


//@Entity
//class BattleEntity(
//    @Column(nullable = false, updatable = true)
//    var countOfRounds: Int,
//
//    @Column(nullable = false, updatable = true)
//    var status: BattleStatus,
//
//    @OneToMany
//    var players: List<PlayerEntity> = mutableListOf()
//): AbstractEntity()