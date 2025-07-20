package blackjack.model.states

interface Running : State {
    override fun profit(money: Int): Double {
       throw IllegalStateException()
    }
}
