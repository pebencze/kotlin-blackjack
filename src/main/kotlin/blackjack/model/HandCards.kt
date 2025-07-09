package blackjack.model

class HandCards(val cards: MutableList<Card> = mutableListOf(), val total: Int = 0) {
    fun add(card: Card) {
        cards.add(card)
    }
}
