package quizbackend.seaBattleApi.restAPI.database.dao

import quizbackend.seaBattleApi.restAPI.database.PlayerEntity

interface PlayerDao: CommonDao<PlayerEntity> {
    fun findPlayerEntityById(id: Long): PlayerEntity
}
