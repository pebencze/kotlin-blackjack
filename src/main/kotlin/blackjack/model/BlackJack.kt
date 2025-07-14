package blackjack.model

class BlackJack(
    override val hand: HandCards = HandCards(),
    override val rate: Double = 1.5
) : Stop() {
    init {
        if (hand.total() != 21 && hand.size() != 2) { throw IllegalStateException() }
    }
}
