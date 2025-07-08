package blackjack.controller

import blackjack.model.ErrorMessage
import blackjack.model.HandCards
import blackjack.view.InputView
import blackjack.model.Player
import blackjack.model.Players
import blackjack.view.OutputView

class Controller {

    fun runGame() {
        val players = initializePlayers()
        OutputView.displayPlayerNames(players)
    }

    fun initializePlayers(): Players {
        repeat(5) {
            try {
                val playerNames = InputView.readNames()
                val players = Players(playerNames.map { Player(it, HandCards()) })
                return players
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw RuntimeException(ErrorMessage.MAX_TRIES.message)
    }

    companion object{
        const val MAX_TRIES = 5
    }
}