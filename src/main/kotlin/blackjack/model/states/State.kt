package blackjack.model.states

import blackjack.model.Card
import blackjack.model.HandCards

interface State {
    val hand: HandCards
    fun draw(card: Card): State
    fun stay(): State
    fun profit(money: Int, dealerState: State): Double
}
