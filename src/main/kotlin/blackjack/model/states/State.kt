package blackjack.model.states

import blackjack.model.Bet
import blackjack.model.Card
import blackjack.model.HandCards

interface State {
    val hand: HandCards
    fun draw(card: Card): State
    fun stay(): State
    fun profit(bet: Bet, dealerState: State): Double
}
