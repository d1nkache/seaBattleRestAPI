package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class PlayerEvent {
    CHOOSE_ONLINE_GAME,
    CHOOSE_OFFLINE_GAME,
    PLACE_ALL_SHIPS,
    START_ATTACK,
    RECEIVE_HIT,
    EXIT_FROM_GAME,
    WIN,
    LOSE,
    BACK_IN_MENU,
    DISCONNECT,
    RECONNECT
}
