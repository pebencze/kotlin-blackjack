package blackjack.model.states

import blackjack.model.HandCards

class Bust(
    override val hand: HandCards,
    override val rate: Double = -1.0
) : Stopped() {
    init {
        if (hand.total() <= 21) { throw IllegalStateException() }
    }

    override fun profit(money: Int, dealerState: State): Double {
        return money * rate
    }

}
