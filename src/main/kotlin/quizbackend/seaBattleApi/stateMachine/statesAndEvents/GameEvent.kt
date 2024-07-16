package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class GameEvent {
    PLAY_ONLINE,
    PLAY_OFFLINE,
    START_BATTLE,
    CHANGE_PLAYER_ON_BOT,
    PLAYER_RECONNECTED,
    CHECK_COUNT_OF_PLAYERS,
    CHECK_COUNT_OF_SHIPS,
    CHOOSE_WINNER
}