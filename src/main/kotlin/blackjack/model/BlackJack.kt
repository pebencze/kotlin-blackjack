package blackjack.model

class BlackJack(override val hand: HandCards = HandCards()) : State {
    init {
        if (hand.total() != 21 && hand.size() != 2) { throw IllegalStateException() }
    }

    override fun draw(card: Card): State {
        throw IllegalStateException()
    }

    override fun stay(): State {
        throw IllegalStateException()
    }
}
