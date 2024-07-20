package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class GameState {
    MAIN_MENU,
    NOT_INIT,
    ONLINE_LOBBY,
    OFFLINE_LOBBY,
    ONE_PLAYER_READY,
    BOTH_PLAYERS_READY,
    ONLINE_GAME_IN_PROCESS,
    OFFLINE_GAME_IN_PROCESS,
    GAME_OVER,
    PLAYER_DISCONNECTED
}
