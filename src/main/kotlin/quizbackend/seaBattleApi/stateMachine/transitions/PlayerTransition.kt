package quizbackend.seaBattleApi.stateMachine.transitions

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.*


// Добавить переходы при ошибках
// Добавить бэкап
class PlayerTransition(
    currentState: PlayerState,
    event: Event,
    nextState: PlayerState
) : AbstractTransition<PlayerState>(currentState, event, nextState) {
    companion object {
        val playerTransitions = listOf(
            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME), PlayerState.IN_ONLINE_LOBBY),
            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_OFFLINE_GAME), PlayerState.IN_OFFLINE_LOBBY),
            PlayerTransition(PlayerState.IN_ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), PlayerState.IN_MENU),
            PlayerTransition(PlayerState.IN_OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), PlayerState.IN_MENU),

            PlayerTransition(PlayerState.IN_ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), PlayerState.READY_FOR_GAME),
            PlayerTransition(PlayerState.IN_OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), PlayerState.READY_FOR_GAME),
            PlayerTransition(PlayerState.READY_FOR_GAME, Event.EventsOfGame(GameEvent.ALL_PLAYERS_READY), PlayerState.IN_GAME),

            PlayerTransition(PlayerState.IN_GAME, Event.EventsOfPlayer(PlayerEvent.START_ATTACK), PlayerState.ATTACK_ENEMY),
            PlayerTransition(PlayerState.IN_GAME, Event.EventsOfPlayer(PlayerEvent.RECEIVE_HIT), PlayerState.TAKE_HIT),

            PlayerTransition(PlayerState.TAKE_HIT, Event.EventsOfPlayer(PlayerEvent.START_ATTACK), PlayerState.ATTACK_ENEMY),
            PlayerTransition(PlayerState.ATTACK_ENEMY, Event.EventsOfPlayer(PlayerEvent.RECEIVE_HIT), PlayerState.TAKE_HIT),

            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.RECONNECT), PlayerState.IN_WAITING_ROOM),
            PlayerTransition(PlayerState.IN_WAITING_ROOM, Event.EventsOfGame(GameEvent.RETURN_PLAYER), PlayerState.IN_GAME),

            PlayerTransition(PlayerState.IN_GAME, Event.EventsOfPlayer(PlayerEvent.WIN), PlayerState.WIN_GAME),
            PlayerTransition(PlayerState.IN_GAME, Event.EventsOfPlayer(PlayerEvent.LOSE), PlayerState.LOSE_GAME),

            PlayerTransition(PlayerState.LOSE_GAME, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), PlayerState.IN_MENU),
            PlayerTransition(PlayerState.WIN_GAME, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), PlayerState.IN_MENU),
        )
    }
}
