package blackjack.model.states

import blackjack.model.Bet
import blackjack.model.HandCards

class Stay(
    override val hand: HandCards,
    override val rate: Double = 1.0
) : Stopped() {
    init {
        if (hand.size() < 2) { throw IllegalStateException() }
    }

    override fun profit(bet: Bet, dealerState: State): Double {
        return when (dealerState) {
            is BlackJack -> (bet.amount * rate * -1.0)
            is Bust -> (bet.amount * rate)
            is Stay -> {
                when {
                    (dealerState.hand < this.hand) -> (bet.amount * rate)
                    (dealerState.hand > this.hand) -> (bet.amount * rate * -1.0)
                    else -> 0.0
                }
            }
            else -> (bet.amount * rate)
        }
    }
}
