package blackjack.model

interface Participant {
    val name: String
    val handCards: HandCards

    fun drawCard(deck: CardDeck) {
        val card = deck.hit()
        handCards.add(card)
    }
}
