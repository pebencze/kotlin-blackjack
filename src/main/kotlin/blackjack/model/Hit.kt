package blackjack.model

class Hit(override val hand: HandCards = HandCards()) : State {
    override fun draw(card: Card): State {
        return Hit()
    }
}
