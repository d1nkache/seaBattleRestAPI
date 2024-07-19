package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class GameEvent {
    ALL_PLAYERS_READY,
    PLAYER_RECONNECTED,
    CHOOSE_WINNER,
    TIMEOUT
}
