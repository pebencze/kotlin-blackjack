package blackjack.model.states

import blackjack.model.HandCards

class BlackJack(
    override val hand: HandCards = HandCards(),
    override val rate: Double = 1.5
) : Stopped() {
    init {
        if (hand.total() != 21 && hand.size() != 2) { throw IllegalStateException() }
    }
}
