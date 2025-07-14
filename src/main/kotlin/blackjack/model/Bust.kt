package blackjack.model

class Bust(override val hand: HandCards) : State {
    init {
        if (hand.total() <= 21) { throw IllegalStateException() }
    }
    override fun draw(card: Card): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        return Stay(hand)
    }
}
