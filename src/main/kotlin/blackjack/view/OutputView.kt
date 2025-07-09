package blackjack.view

import blackjack.model.Participant
import blackjack.model.Players

object OutputView {
    fun displayPlayerNames(players: Players) {
        println(players.players.joinToString())
    }

    fun displayInitialCardsMessage(players: Players) {
        println("\nDealing two cards to dealer, ${players.players.joinToString()}.")
    }

    fun displayAllCardsMessage(participant: Participant) {
        print(participant.name + "'s cards: ")
        println(participant.cardsToString())
    }

    fun displayFirstCardMessage(participant: Participant) {
        print(participant.name + ": ")
        println(participant.firstCardToString())
    }
}
