package blackjack.model

class Stay(
    override val hand: HandCards,
    override val rate: Double = 1.0
) : Stop() {
    init {
        if (hand.size() < 2) { throw IllegalStateException() }
    }
}
