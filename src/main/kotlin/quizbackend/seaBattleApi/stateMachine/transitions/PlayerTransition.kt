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
        val allPlayerTransitions = listOf(
            // Transitions from IN_MENU state
            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME), PlayerState.IN_ONLINE_LOBBY),
            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_OFFLINE_GAME), PlayerState.IN_OFFLINE_LOBBY),
            PlayerTransition(PlayerState.IN_MENU, Event.EventsOfPlayer(PlayerEvent.RECONNECT), PlayerState.IN_GAME),

            // Transitions from IN_ONLINE_LOBBY state
            PlayerTransition(PlayerState.IN_ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), PlayerState.IN_MENU),
            PlayerTransition(PlayerState.IN_ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), PlayerState.READY_FOR_GAME),

            // Transitions from IN_OFFLINE_LOBBY state
            PlayerTransition(PlayerState.IN_OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), PlayerState.IN_MENU),
            PlayerTransition(PlayerState.IN_OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), PlayerState.TAKE_HIT),
            PlayerTransition(PlayerState.IN_OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), PlayerState.ATTACK_ENEMY),

            // Transitions from READY_FOR_GAME state
            PlayerTransition(PlayerState.READY_FOR_GAME, Event.EventsOfGame(GameEvent.ALL_PLAYERS_READY), PlayerState.TAKE_HIT),
            PlayerTransition(PlayerState.READY_FOR_GAME, Event.EventsOfGame(GameEvent.ALL_PLAYERS_READY), PlayerState.ATTACK_ENEMY),

            // Transitions from TAKE_HIT state
            PlayerTransition(PlayerState.TAKE_HIT, Event.EventsOfPlayer(PlayerEvent.BLOW_WAS_RECEIVED), PlayerState.ATTACK_ENEMY),
            PlayerTransition(PlayerState.TAKE_HIT, Event.EventsOfPlayer(PlayerEvent.WIN), PlayerState.WIN_GAME),
            PlayerTransition(PlayerState.TAKE_HIT, Event.EventsOfPlayer(PlayerEvent.LOSE), PlayerState.LOSE_GAME),
            PlayerTransition(PlayerState.TAKE_HIT, Event.EventsOfPlayer(PlayerEvent.EXIT_FROM_GAME), PlayerState.IN_MENU),

            // Transitions from ATTACK_ENEMY state
            PlayerTransition(PlayerState.ATTACK_ENEMY, Event.EventsOfPlayer(PlayerEvent.SHOOT), PlayerState.TAKE_HIT),
            PlayerTransition(PlayerState.ATTACK_ENEMY, Event.EventsOfPlayer(PlayerEvent.WIN), PlayerState.WIN_GAME),
            PlayerTransition(PlayerState.ATTACK_ENEMY, Event.EventsOfPlayer(PlayerEvent.LOSE), PlayerState.LOSE_GAME),
            PlayerTransition(PlayerState.ATTACK_ENEMY, Event.EventsOfPlayer(PlayerEvent.EXIT_FROM_GAME), PlayerState.IN_MENU),

            // Transitions from WIN_GAME state
            PlayerTransition(PlayerState.WIN_GAME, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), PlayerState.IN_MENU),

            // Transitions from LOSE_GAME state
            PlayerTransition(PlayerState.LOSE_GAME, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), PlayerState.IN_MENU),
        )
    }
}
