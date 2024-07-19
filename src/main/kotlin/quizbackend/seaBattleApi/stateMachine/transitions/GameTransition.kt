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
            // MAIN_MENU Transitions
            GameTransition(GameState.MAIN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_ONLINE_GAME), GameState.ONLINE_LOBBY),
            GameTransition(GameState.MAIN_MENU, Event.EventsOfPlayer(PlayerEvent.CHOOSE_OFFLINE_GAME), GameState.OFFLINE_LOBBY),
            GameTransition(GameState.MAIN_MENU, Event.EventsOfPlayer(PlayerEvent.RECONNECT), GameState.ONLINE_GAME_IN_PROCESS),

            // ONLINE_LOBBY Transitions
            GameTransition(GameState.ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.ONE_PLAYER_READY),
            GameTransition(GameState.ONLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),

            // ONE_PLAYER_READY Transitions
            GameTransition(GameState.ONE_PLAYER_READY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.BOTH_PLAYERS_READY),
            GameTransition(GameState.ONE_PLAYER_READY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),

            // BOTH_PLAYERS_READY Transitions
            GameTransition(GameState.BOTH_PLAYERS_READY, Event.EventsOfGame(GameEvent.ALL_PLAYERS_READY), GameState.ONLINE_GAME_IN_PROCESS),
            GameTransition(GameState.BOTH_PLAYERS_READY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),

            // OFFLINE_LOBBY Transitions
            GameTransition(GameState.OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.PLACE_ALL_SHIPS), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.OFFLINE_LOBBY, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.MAIN_MENU),

            // ONLINE_GAME_IN_PROCESS Transitions
            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.EXIT_FROM_GAME), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.TIMEOUT), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.OFFLINE_GAME_IN_PROCESS),
            GameTransition(GameState.ONLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.CHOOSE_WINNER), GameState.GAME_OVER),


            // OFFLINE_GAME_IN_PROCESS Transitions
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.EXIT_FROM_GAME), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.TIMEOUT), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfPlayer(PlayerEvent.DISCONNECT), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.CHOOSE_WINNER), GameState.GAME_OVER),
            GameTransition(GameState.OFFLINE_GAME_IN_PROCESS, Event.EventsOfGame(GameEvent.PLAYER_RECONNECTED), GameState.ONLINE_GAME_IN_PROCESS),

            // GAME_OVER Transitions
            GameTransition(GameState.GAME_OVER, Event.EventsOfPlayer(PlayerEvent.BACK_IN_MENU), GameState.MAIN_MENU)
        )

    }
}
