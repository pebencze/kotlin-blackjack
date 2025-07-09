package blackjack.controller

import blackjack.model.CardDeck
import blackjack.model.Dealer
import blackjack.model.ErrorMessage
import blackjack.model.Player
import blackjack.model.Players
import blackjack.view.InputView
import blackjack.view.OutputView
import blackjack.view.OutputView.displayInitialCardsMessage

class Controller {
    private val deck = CardDeck()
    private var players: Players? = null
    private val dealer = Dealer()

    fun runGame() {
        players = initializePlayers()
        OutputView.displayPlayerNames(players!!)
        drawInitialCards()
        OutputView.displayFirstCardMessage(dealer)
//        OutputView.displayAllCardsMessage(players!!.players[0])
        players!!.forEach { OutputView.displayAllCardsMessage(it) }
    }

    fun initializePlayers(): Players {
        repeat(5) {
            try {
                val playerNames = InputView.readNames()
                val players = Players(playerNames.map { Player(it) })
                return players
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw RuntimeException(ErrorMessage.MAX_TRIES.message)
    }

    fun drawInitialCards() {
        displayInitialCardsMessage(players!!)
        repeat(2) {
            dealer.drawCard(deck)
            players!!.forEach { it.drawCard(deck) }
        }
    }

    companion object {
        const val MAX_TRIES = 5
    }
}
