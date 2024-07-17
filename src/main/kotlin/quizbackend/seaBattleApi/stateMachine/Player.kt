package quizbackend.seaBattleApi.stateMachine

import quizbackend.seaBattleApi.stateMachine.statesAndEvents.PlayerState

// пока что заглушка, на его месте будет Entity
class Player(private val playerId: Int, private var playerState: PlayerState)