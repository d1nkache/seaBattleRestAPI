package quizbackend.seaBattleApi.RestAPI.database.dao

import org.springframework.data.repository.CrudRepository
import quizbackend.seaBattleApi.RestAPI.database.AbstractEntity

interface CommonDao<T: AbstractEntity>: CrudRepository<T, Long>