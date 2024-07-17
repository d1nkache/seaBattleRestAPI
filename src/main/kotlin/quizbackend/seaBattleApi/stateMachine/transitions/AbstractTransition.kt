package quizbackend.seaBattleApi.stateMachine.transitions

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*

abstract class AbstractTransition<State> (
    val currentState: State,
    val event: Event,
    val nextState: State
)
