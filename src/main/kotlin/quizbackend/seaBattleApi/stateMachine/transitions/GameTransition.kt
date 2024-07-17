package quizbackend.seaBattleApi.stateMachine.transitions

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.Event
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameEvent
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.GameState
import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerEvent

class GameTransition(
    gameState: GameState,
    event: Event,
    nextState: GameState
) : AbstractTransition<GameState>(gameState, event, nextState) {
    companion object {
        val allGameTransitions: List<GameTransition> = listOf(
            GameTransition(GameState.MAIN_MENU, Event.EventsOfGame(GameEvent.PLAY_ONLINE), GameState.ONLINE_LOBBY),
            GameTransition(GameState.MAIN_MENU, Event.EventsOfGame(GameEvent.PLAY_OFFLINE), GameState.OFFLINE_LOBBY),

            GameTransition(GameState.ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.ONE_PLAYER_READY),
            GameTransition(GameState.ONE_PLAYER_READY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.BOTH_PLAYERS_READY),
            GameTransition(GameState.BOTH_PLAYERS_READY, Event.EventsOfGame(GameEvent.ALL_PLAYERS_READY), GameState.ONLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),
            GameTransition(GameState.ONE_PLAYER_READY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),
            GameTransition(GameState.BOTH_PLAYERS_READY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),

            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.EXIT_FROM_GAME), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.PAUSE_ON_CHECK_STATUS), GameState.IS_ALL_ONLINE),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.PAUSE_ON_CHECK_STATUS), GameState.IS_ALL_ONLINE),
            GameTransition(GameState.IS_ALL_ONLINE, Event.EventsOfGame(GameEvent.PAUSE_ON_CHECK_COUNT_OF_SHIPS), GameState.IS_ALL_ALIVE),
            GameTransition(GameState.IS_ALL_ONLINE, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.PLAYER_DISCONNECTED),
            GameTransition(GameState.PLAYER_DISCONNECTED, Event.EventsOfGame(GameEvent.CHANGE_PLAYER_ON_BOT), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.RECONNECT), GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM, Event.EventsOfGame(GameEvent.RETURN_PLAYER), GameState.ONLINE_GAME_IN_PROCESS),

            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.START_ATTACK), GameState.ONLINE_GAME_IN_PROCESS_ATTACK_STATE),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.START_ATTACK), GameState.OFFLINE_GAME_IN_PROCESS_ATTACK_STATE),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM, Event.EventsOfPlayer(PlayerEvent.START_ATTACK), GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM_ATTACK_STATE),

            GameTransition(GameState.ONLINE_GAME_IN_PROCESS_ATTACK_STATE, Event.EventsOfGame(GameEvent.TIMEOUT), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_ATTACK_STATE, Event.EventsOfGame(GameEvent.TIMEOUT), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM_ATTACK_STATE, Event.EventsOfGame(GameEvent.TIMEOUT), GameState.GAME_OVER),

            GameTransition(GameState.ONLINE_GAME_IN_PROCESS_ATTACK_STATE, Event.EventsOfGame(GameEvent.BOTH_PLAYERS_ATTACKED), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_ATTACK_STATE, Event.EventsOfGame(GameEvent.BOTH_PLAYERS_ATTACKED), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM_ATTACK_STATE, Event.EventsOfGame(GameEvent.BOTH_PLAYERS_ATTACKED), GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM),

            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.CHOOSE_WINNER), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.CHOOSE_WINNER), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS_WITH_ONE_PLAYER_IN_WAITING_ROOM, Event.EventsOfGame(GameEvent.CHOOSE_WINNER), GameState.GAME_OVER),

            GameTransition(GameState.GAME_OVER, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), GameState.MAIN_MENU)
        )
    }
}
