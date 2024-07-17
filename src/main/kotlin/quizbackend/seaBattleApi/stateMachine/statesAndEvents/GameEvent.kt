package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class GameEvent {
    PLAY_ONLINE,
    PLAY_OFFLINE,
    ALL_PLAYERS_READY,
    CHANGE_PLAYER_ON_BOT,
    PAUSE_ON_CHECK_STATUS,
    PAUSE_ON_CHECK_COUNT_OF_SHIPS,
    BOTH_PLAYERS_ATTACKED,
    RETURN_PLAYER,
    CHOOSE_WINNER,
    PAUSE_GAME,
    RESUME_GAME,
    TIMEOUT
}
