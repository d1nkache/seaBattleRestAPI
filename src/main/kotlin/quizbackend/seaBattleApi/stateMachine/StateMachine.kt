package quizbackend.seaBattleApi.stateMachine

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.FieldState
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerEvent
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

// в первичном контсукторе я поставил временные заглушки,
// вместо которых будут данные из бд о текузем юзере

// может есть смысл добавить sealed класс ???
class StateMachine(private val gameId: Int, private val userId: Int) {
    var gameState: GameState = GameState.MAIN_MENU
    var players: MutableList<Player> = mutableListOf()

    fun handlePlayerState(playerEvent: PlayerEvent): PlayerState {
        TODO("Not yet implemented")
    }

    fun handleGameState(gameState: GameState): GameState {
        TODO("Not yet implemented")
    }

    fun handleFieldState(fieldState: FieldState): PlayerState {
        TODO("Not yet implemented")
    }
}


