package blackjack.model

interface Participant {
    val name: String
    val handCards: HandCards

    fun drawCard(deck: CardDeck) {
        val card = deck.hit()
        handCards.add(card)
    }

    fun isNotBusted(): Boolean {
        return (handCards.total <= 21)
    }

    fun cardsToString(): String {
        return handCards.cards.joinToString()
    }

    fun firstCardToString(): String {
        return handCards.cards[0].toString()
    }
}
