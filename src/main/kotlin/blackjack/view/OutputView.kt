package blackjack.view

import blackjack.model.Dealer
import blackjack.model.Participant
import blackjack.model.Players
import blackjack.model.Results

object OutputView {
    fun displayPlayerNames(players: Players) {
        println(players.players.joinToString())
    }

    fun displayInitialCardsMessage(players: Players) {
        println("\nDealing two cards to dealer, ${players.players.joinToString()}.")
    }

    fun displayAllCardsMessage(participant: Participant) {
        println("${participant.name}'s cards: ${participant.cardsToString()}")
    }

    fun displayFirstCardMessage(participant: Participant) {
        println("${participant.name}: ${participant.firstCardToString()}")
    }

    fun displayDealerDrawMessage() {
        println("\nDealer draws one more card due to having 16 or less.")
    }

    fun displayParticipantStatus(participant: Participant){
        if (participant is Dealer)
            println()
        print("${participant.name}'s cards: ${participant.cardsToString()}")
        println(" – Total: ${participant.handCards.total}")
    }

    fun displayResults(results: Results) {
        println("\n## Final Results:")
        println(results.component1())
        results.component2().forEach { println(it) }
    }
}
