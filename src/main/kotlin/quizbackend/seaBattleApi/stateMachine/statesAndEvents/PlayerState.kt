package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class PlayerState {
    IN_MENU,
    IN_ONLINE_LOBBY,
    IN_OFFLINE_LOBBY,
    READY_FOR_GAME,
    IN_GAME,
    ATTACK_ENEMY,
    TAKE_HIT,
    IN_WAITING_ROOM,
    WIN_GAME,
    LOSE_GAME
}