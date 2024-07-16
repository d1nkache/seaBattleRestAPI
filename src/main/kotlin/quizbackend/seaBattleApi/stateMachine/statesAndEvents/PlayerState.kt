package quizbackend.seaBattleApi.stateMachine.statesAndEvents

enum class PlayerState {
    IN_MENU,
    IN_LOBBY,
    PLACING_SHIPS,
    READY_FOR_GAME,
    IN_GAME,
    ATTACK_ENEMY,
    TAKE_HIT,
    DISCONNECTED_FROM_BATTLE,
    WIN_GAME,
    LOSE_GAME
}