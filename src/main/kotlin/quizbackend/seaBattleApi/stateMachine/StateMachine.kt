package quizbackend.seaBattleApi.stateMachine

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*
import quizbackend.seaBattleApi.stateMachine.transitions.AbstractTransition
import quizbackend.seaBattleApi.stateMachine.transitions.GameTransition
import quizbackend.seaBattleApi.stateMachine.transitions.PlayerTransition

// в первичном контсукторе я поставил временные заглушки,
// вместо которых будут данные из бд о текузем юзере

class StateMachine(private val gameId: Int, private val playerId: Int) {
    private var gameState: GameState = GameState.MAIN_MENU
    private var players: MutableMap<String, Player> = mutableMapOf()

    private fun <State>findTransition(
        event: Event,
        state: State,
        listOfTransition: List<AbstractTransition<State>>
    ): AbstractTransition<State>? {
        return listOfTransition.find {
            it.event == event && it.currentState == state
        }
    }

    private fun findPlayerById(playerId: Int) = players.values.find {
            it.playerId == playerId
        }

    private fun handlePlayerEvent(
        event: Event,
        currentPlayer: Player?,
        currentPlayerTransition: AbstractTransition<PlayerState>?,
        currentGameTransition: AbstractTransition<GameState>?
    ): String {
        if (currentPlayerTransition != null && currentPlayer != null) {
            if (currentPlayerTransition.nextState != currentPlayer.playerState) {
                currentPlayer.playerState = currentPlayerTransition.nextState

                if (currentGameTransition != null) {
                    gameState = currentGameTransition.nextState

                        // Влияние на сущности из БД добавить

                    return """Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.playerState.toString()}
                           | Success[GameTransition]: ${currentGameTransition.currentState} -> ${gameState.toString()}""".trimMargin()
                }

                return "Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.playerState.toString()}"
            }

            return "Error: Current Player State == PlayerTransition.nextState"
        }

        return "Error: No such Player or PlayerTransition"
    }

    private fun handleGameEvent(
        event: Event,
        currentPlayer: Player?,
        currentPlayerTransition: AbstractTransition<PlayerState>?,
        currentGameTransition: AbstractTransition<GameState>?
    ): String {
        if (currentGameTransition != null) {
            gameState = currentGameTransition.nextState

            if (currentPlayerTransition != null && currentPlayer != null)  {
                if (currentPlayerTransition.nextState != currentPlayer.playerState) {
                    currentPlayer.playerState = currentPlayerTransition.nextState

                // Влияние на сущности из БД добавить

                    return """Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${gameState.toString()}
                           | Success[PlayerTransition]: ${currentPlayerTransition.currentState.toString()} -> ${currentPlayer.playerState.toString()}""".trimMargin()
                }

                return "Error: Current Player State == PlayerTransition.nextState"
            }

            return "Success[GameTransition]: ${currentGameTransition.currentState.toString()} -> ${gameState.toString()}"
        }

        return "Error: No such Player or PlayerTransition"
    }

    private fun handleFieldEvent(): String {
        TODO("Not implemented yet")
    }

    fun handleEvent(event: Event): String {
        val currentPlayer: Player? = findPlayerById(playerId)
        val currentPlayerTransition = currentPlayer?.let {
            findTransition(event, it.playerState, PlayerTransition.allPlayerTransitions)
        }
        val currentGameTransition: AbstractTransition<GameState>? =
            findTransition(event, gameState, GameTransition.allGameTransitions)

        when (event) {
            is Event.EventsOfPlayer -> handlePlayerEvent(event, currentPlayer, currentPlayerTransition, currentGameTransition)
            is Event.EventsOfGame -> handleGameEvent(event, currentPlayer, currentPlayerTransition, currentGameTransition)
            is Event.EventsOfField -> handleFieldEvent()
        }

        return "ERROR"
    }
}


