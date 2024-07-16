package quizbackend.seaBattleApi.stateMachine.transitions

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameEvent
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState
import javax.swing.AbstractAction

class GameTransition(
    gameState: GameState,
    event: GameEvent,
    nextState: GameState
) : AbstractTransition<GameState, GameEvent>(gameState, event, nextState)