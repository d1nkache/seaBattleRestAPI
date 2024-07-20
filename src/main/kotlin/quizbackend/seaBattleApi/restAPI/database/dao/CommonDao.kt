package quizbackend.seaBattleApi.restAPI.database.dao

import org.springframework.data.repository.CrudRepository
import quizbackend.seaBattleApi.restAPI.database.AbstractEntity

interface CommonDao<T: AbstractEntity>: CrudRepository<T, Long>