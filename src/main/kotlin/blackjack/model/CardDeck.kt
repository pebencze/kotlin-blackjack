package blackjack.model

class CardDeck(
    val deck: ArrayDeque<Card> = ArrayDeque(),
) {
    init {
        generateDeck()
    }

    val size: Int
        get() = deck.size

    private fun generateDeck() {
        Suit.entries.forEach { suit ->
            Rank.entries.forEach { rank ->
                deck.addFirst(Card(rank, suit))
            }
        }
    }
}