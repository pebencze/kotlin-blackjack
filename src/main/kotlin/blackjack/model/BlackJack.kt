package blackjack.model

class BlackJack(override val hand: HandCards = HandCards()) : State {
    override fun draw(card: Card): State {
        return BlackJack()
    }
}
