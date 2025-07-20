package blackjack.model.states

import blackjack.model.Card

abstract class Stopped : State {
    abstract val rate: Double

    override fun draw(card: Card): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        throw IllegalStateException()
    }

    fun profit(money: Int): Double {
        return money * rate
    }
}
