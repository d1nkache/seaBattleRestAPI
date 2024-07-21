
package quizbackend.seaBattleApi.stateMachine

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import quizbackend.seaBattleApi.RestAPI.database.GameEntity
import quizbackend.seaBattleApi.RestAPI.database.PlayerEntity
import quizbackend.seaBattleApi.RestAPI.database.dao.GameDao
import quizbackend.seaBattleApi.RestAPI.database.dao.PlayerDao
import quizbackend.seaBattleApi.RestAPI.model.response.TransitionResponse
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*
import quizbackend.seaBattleApi.stateMachine.transitions.AbstractTransition

// в первичном контсукторе я поставил временные заглушки,
// вместо которых будут данные из бд о текузем юзере


@Service
class StateMachine(
    private val playerDao: PlayerDao,
    private val gameDao: GameDao
) {
    @Transactional
    @Modifying
    fun handlePlayerEvent(
        currentPlayer: PlayerEntity,
        currentGame: GameEntity,
        currentPlayerTransition: AbstractTransition<PlayerState>,
        currentGameTransition: AbstractTransition<GameState>,
        transitionResponse: TransitionResponse
    ): Unit {
        if (currentPlayerTransition.nextState != currentPlayer.state) {
            println(currentPlayerTransition.nextState)
            currentPlayer.state = currentPlayerTransition.nextState
            transitionResponse.map["PlayerTransition"] = "Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.state}"

            if (currentGameTransition.nextState != currentGame.state) {
                currentGame.state = currentGameTransition.nextState
                transitionResponse.map["GameTransition"] = "Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state}"
                println("""Success[PlayerTransition]: ${currentPlayerTransition.currentState} -> ${currentPlayer.state}
                       | Success[GameTransition]: ${currentGameTransition.currentState} -> ${currentGame.state}""".trimMargin())

                return
            }

            println("Success[PlayerTransition]: ${currentPlayerTransition.currentState} -> ${currentPlayer.state}")

            return
        }
    }

    @Transactional
    @Modifying
    fun handleGameEvent(
        currentPlayer: PlayerEntity,
        currentGame:GameEntity,
        currentPlayerTransition: AbstractTransition<PlayerState>,
        currentGameTransition: AbstractTransition<GameState>,
        transitionResponse: TransitionResponse
    ): Unit {
        if (currentGameTransition.nextState != currentGame.state) {
            currentGame.state = currentGameTransition.nextState
            transitionResponse.map["GameTransition"] = "Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state}"

            if (currentPlayerTransition.nextState != currentPlayer.state) {
                currentPlayer.state = currentPlayerTransition.nextState
                transitionResponse.map["PlayerTransition"] = "Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.state}"

                print("""Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state}
                       | Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.state}""".trimMargin())

                return
            }

            print("Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${currentGame.state.toString()}")

            return
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

    @Transactional
    @Modifying
    fun handleEvent(event: Event,
                    currentPlayer: PlayerEntity,
                    currentGame:GameEntity,
                    currentPlayerTransition: AbstractTransition<PlayerState>,
                    currentGameTransition: AbstractTransition<GameState>,
                    transitionResponse: TransitionResponse
    ): Unit {
        when (event) {
            is Event.EventsOfPlayer -> handlePlayerEvent(currentPlayer, currentGame, currentPlayerTransition, currentGameTransition, transitionResponse)
            is Event.EventsOfGame -> handleGameEvent(currentPlayer, currentGame, currentPlayerTransition, currentGameTransition, transitionResponse)
            is Event.EventsOfField -> handleFieldEvent()
        }

        print("The transition was successful")
    }
}
