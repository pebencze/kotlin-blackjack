package blackjack.model

class Stay(override val hand: HandCards) : State {
    override fun draw(card: Card): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        return Stay(hand)
    }
}
