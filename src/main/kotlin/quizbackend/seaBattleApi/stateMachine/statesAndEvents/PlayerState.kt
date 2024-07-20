package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class PlayerState {
    IN_MENU,
    NOT_INIT,
    IN_ONLINE_LOBBY,
    IN_OFFLINE_LOBBY,
    READY_FOR_GAME,
    IN_GAME,
    ATTACK_ENEMY,
    TAKE_HIT,
    WIN_GAME,
    LOSE_GAME
}