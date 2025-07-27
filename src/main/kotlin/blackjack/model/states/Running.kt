package blackjack.model.states

interface Running : State {
    override fun profit(money: Int, dealerState: State): Double {
       throw IllegalStateException()
    }
}
