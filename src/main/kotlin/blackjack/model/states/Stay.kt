package blackjack.model.states

import blackjack.model.HandCards

class Stay(
    override val hand: HandCards,
    override val rate: Double = 1.0
) : Stopped() {
    init {
        if (hand.size() < 2) { throw IllegalStateException() }
    }
}
