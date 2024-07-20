package quizbackend.seaBattleApi.restAPI.database

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
}


// игрок вышел окончательно
// бот вместо игрока
// из-за сети