package quizbackend.seaBattleApi.stateMachine

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional
import quizbackend.seaBattleApi.RestAPI.database.GameEntity
import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*
import quizbackend.seaBattleApi.stateMachine.transitions.AbstractTransition
import quizbackend.seaBattleApi.stateMachine.transitions.GameTransition
import quizbackend.seaBattleApi.stateMachine.transitions.PlayerTransition

// в первичном контсукторе я поставил временные заглушки,
// вместо которых будут данные из бд о текузем юзере


@Configuration
class StateMachine(
    private val playerDao: PlayerDao,
    private val gameDao: GameDao
) {
    @Transactional
    @Modifying
    fun handlePlayerEvent(
        currentPlayer: PlayerEntity,
        currentGame:GameEntity,
        currentPlayerTransition: AbstractTransition<PlayerState>?,
        currentGameTransition: AbstractTransition<GameState>?
    ): Unit {
        if (currentPlayerTransition != null) {
            if (currentPlayerTransition.nextState != currentPlayer.state) {
                currentPlayer.state = currentPlayerTransition.nextState

                if (currentGameTransition != null) {
                    currentGame.state = currentGameTransition.nextState
                    print("""Success[PlayerTransition]: ${currentPlayerTransition.currentState} -> ${currentPlayer.state}
                           | Success[GameTransition]: ${currentGameTransition.currentState} -> ${currentGame.state}""".trimMargin())
                }

                print("Success[PlayerTransition]: ${currentPlayerTransition.currentState} -> ${currentPlayer.state}")
            }

            print("Error: Current Player State == PlayerTransition.nextState")
        }

        print("Error: No such Player or PlayerTransition")
    }

    @Transactional
    @Modifying
    fun handleGameEvent(
        currentPlayer: PlayerEntity,
        currentGame:GameEntity,
        currentPlayerTransition: AbstractTransition<PlayerState>?,
        currentGameTransition: AbstractTransition<GameState>?
    ): Unit {
        if (currentGameTransition != null) {
            currentGame.state = currentGameTransition.nextState

            if (currentPlayerTransition != null)  {
                if (currentPlayerTransition.nextState != currentPlayer.state) {
                    currentPlayer.state = currentPlayerTransition.nextState

                    print("""Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state}
                           | Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.state}""".trimMargin())
                }

                print("Error: Current Player State == PlayerTransition.nextState")
            }

            print("Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state.toString()}")
        }

        print("Error: No such Player or PlayerTransition")
    }

    private fun handleFieldEvent(): String {
        TODO("Not implemented yet")
    }

    fun <State>findTransition(
        event: Event,
        state: State,
        listOfTransition: List<AbstractTransition<State>>
    ): AbstractTransition<State>? {
        return listOfTransition.find {
            it.event == event && it.currentState == state
        }
    }

    fun handleEvent(event: Event,
                    currentPlayer: PlayerEntity,
                    currentGame:GameEntity,
                    currentPlayerTransition: AbstractTransition<PlayerState>?,
                    currentGameTransition: AbstractTransition<GameState>?
    ): Unit {
        when (event) {
            is Event.EventsOfPlayer -> handlePlayerEvent(currentPlayer, currentGame, currentPlayerTransition, currentGameTransition)
            is Event.EventsOfGame -> handleGameEvent(currentPlayer, currentGame, currentPlayerTransition, currentGameTransition)
            is Event.EventsOfField -> handleFieldEvent()
        }

        print("The transition was successful")
    }
}


