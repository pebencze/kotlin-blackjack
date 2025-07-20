package blackjack.controller

import blackjack.model.Bet
import blackjack.model.CardDeck
import blackjack.model.Dealer
import blackjack.model.ErrorMessage
import blackjack.model.Player
import blackjack.model.Players
import blackjack.model.states.Running
import blackjack.view.InputView
import blackjack.view.OutputView

class Controller {
    fun runGame() {
        val players = initializePlayers()
        val dealer = Dealer()
        val deck = CardDeck()

        players.forEach { setBettingAmount(it) }

        // TODO("put following logic into a Game class")
        firstRound(players, dealer, deck)
        dealToPlayers(players, deck)
        dealToDealer(dealer, deck)
        displayCardsAndTotal(dealer, players)
//        printResults()
    }

    private fun initializePlayers(): Players {
        repeat(MAX_TRIES) {
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

    private fun setBettingAmount(player: Player) {
        repeat(MAX_TRIES) {
            try {
                player.bet = Bet.of(InputView.readBettingAmount(player))
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw RuntimeException(ErrorMessage.MAX_TRIES.message)
    }
//
//    private fun printResults() {
//        val evaluator = ResultEvaluator(players, dealer)
//        val results = evaluator.calculateResults()
//        OutputView.displayResults(results)
//    }
//
    private fun displayCardsAndTotal(dealer: Dealer, players: Players) {
        OutputView.displayParticipantStatus(dealer)
        players.forEach { OutputView.displayParticipantStatus(it) }
    }

    private fun dealToDealer(dealer: Dealer, deck: CardDeck) {
        while (dealer.state is Running) {
            OutputView.displayDealerDrawMessage()
            if (dealer.shouldDraw()) dealer.state = dealer.state.draw(deck.hit())
            else dealer.state = dealer.state.stay()
        }
    }

    private fun dealToPlayers(players: Players, deck: CardDeck) {
        players.forEach { dealToPlayer(it, deck) }
    }

    fun dealToPlayer(player: Player, deck: CardDeck) {
        while (player.state is Running) {
            if (wantsToDraw(player)) player.state = player.state.draw(deck.hit())
            else player.state = player.state.stay()
            OutputView.displayAllCardsMessage(player)
        }
    }

    private fun wantsToDraw(player: Player): Boolean {
        repeat(MAX_TRIES){
            try {
                return InputView.promptForDraw(player)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return@repeat
            }
        }
        throw RuntimeException(ErrorMessage.MAX_TRIES.message)
    }

    private fun firstRound(players: Players, dealer: Dealer, deck: CardDeck) {
        OutputView.displayFirstRoundMessage(players)
        repeat(2) {
            dealer.state = dealer.state.draw(deck.hit())
            players.forEach { it.state = it.state.draw(deck.hit()) }
        }
        OutputView.displayFirstCardMessage(dealer)
        players.forEach { OutputView.displayAllCardsMessage(it) }
    }

    companion object {
        const val MAX_TRIES = 5
    }
}
