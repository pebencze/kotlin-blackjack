package blackjack.model.states

import blackjack.model.HandCards

class Stay(
    override val hand: HandCards,
    override val rate: Double = 1.0
) : Stopped() {
    init {
        if (hand.size() < 2) { throw IllegalStateException() }
    }

    override fun profit(money: Int, dealerState: State): Double {
        return when (dealerState) {
            is BlackJack -> (money * rate * -1.0)
            is Bust -> (money * rate)
            is Stay -> {
                when {
                    (dealerState.hand < this.hand) -> (money * rate)
                    (dealerState.hand > this.hand) -> (money * rate * -1.0)
                    else -> 0.0
                }
            }
            else -> (money * rate)
        }
    }
}
