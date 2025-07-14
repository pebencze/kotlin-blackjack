package blackjack.model

class Bust(
    override val hand: HandCards,
    override val rate: Double = -1.0
) : Stop() {
    init {
        if (hand.total() <= 21) { throw IllegalStateException() }
    }

}
