package quizbackend.seaBattleApi.RestAPI.database.dao

import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity

interface PlayerDao: CommonDao<PlayerEntity> {
    fun findPlayerEntityById(id: Long): PlayerEntity
}
