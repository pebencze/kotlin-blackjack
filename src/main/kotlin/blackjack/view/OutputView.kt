package blackjack.view

import blackjack.model.Card
import blackjack.model.Participant
import blackjack.model.Players

object OutputView {
    fun displayFirstRoundMessage(players: Players) {
        println("\nDealing two cards to dealer, ${players.players.joinToString()}.")
    }

    fun displayAllCardsMessage(participant: Participant) {
        val cards = participant.state.hand.cards
        println("${participant.name}'s cards: ${handCardsToString(cards)}")
    }

    fun displayFirstCardMessage(participant: Participant) {
        val firstCard = participant.state.hand.cards.first()
        println("${participant.name}: ${cardToString(firstCard)}")
    }

    private fun cardToString(card: Card): String {
        return card.rank.title + card.suit.symbol
    }

    private fun handCardsToString(cards: List<Card>): String {
        val sb = StringBuilder()
        cards.forEach {
            sb.append(it.rank.title)
            sb.append(it.suit.symbol)
            sb.append(" ")
        }
        return sb.toString()
    }
//
//    fun displayDealerDrawMessage() {
//        println("\nDealer draws one more card due to having 16 or less.")
//    }
//
//    fun displayParticipantStatus(participant: Participant){
//        if (participant is Dealer)
//            println()
//        print("${participant.name}'s cards: ${participant.cardsToString()}")
//        println(" – Total: ${participant.handCards.total}")
//    }
//
//    fun dealerResultString(result: DealerResult): String {
//        return "Dealer: ${result.wins} wins, ${result.losses} losses, ${result.draws} draws"
//    }
//
//    fun playerResultToString(result: PlayerResult): String {
//        if (result.win) return "${result.name}: win"
//        if (result.draw) return "${result.name}: draw"
//        return "${result.name}: loss"
//    }
//
//    fun displayResults(results: Results) {
//        println("\n## Final Results:")
//        println(dealerResultString(results.dealerResult))
//        results.component2().forEach { println(playerResultToString(it)) }
//    }
}
