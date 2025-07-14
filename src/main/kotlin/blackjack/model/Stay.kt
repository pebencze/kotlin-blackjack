package blackjack.model

class Stay(override val hand: HandCards) : State {
    init {
        if (hand.size() < 2) { throw IllegalStateException() }
    }
    override fun draw(card: Card): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        throw IllegalStateException()
    }
}
