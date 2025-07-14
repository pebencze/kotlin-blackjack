package blackjack.model

abstract class Stop : State {
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
