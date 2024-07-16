package quizbackend.seaBattleApi.stateMachine.transitions

abstract class AbstractTransition<State, Event> (
    val currentState: State,
    val event: Event,
    val nextState: State
)