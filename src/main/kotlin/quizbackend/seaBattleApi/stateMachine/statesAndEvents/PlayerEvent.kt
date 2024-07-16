package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class PlayerEvent {
    CHOOSE_ONLINE_GAME,
    CHOOSE_OFFLINE_GAME,
    PLACE_ALL_SHIPS,
    ALL_PLAYERS_READY,
    START_ATTACK,
    RECEIVE_HIT,
    WIN,
    LOSE,
    DISCONNECT,
    RECONNECT
}
