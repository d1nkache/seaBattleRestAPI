package quizbackend.seaBattleApi.stateMachine.transitions

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerEvent
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

class PlayerTransition(
    currentState: PlayerState,
    event: PlayerEvent,
    nextState: PlayerState
) : AbstractTransition<PlayerState, PlayerEvent>(currentState, event, nextState)
