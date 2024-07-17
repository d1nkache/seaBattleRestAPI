package quizbackend.seaBattleApi.stateMachine.statesAndEvents

sealed class Event {
    data class EventsOfPlayer(val event: PlayerEvent): Event()
    data class EventsOfGame(val event: GameEvent): Event()
    data class EventsOfField(val event: FieldEvent): Event()
}