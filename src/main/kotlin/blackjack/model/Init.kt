package blackjack.model

class Init(override val hand: HandCards = HandCards()) : State {
    init {
        if (hand.cards.size > 1) { throw IllegalStateException() }
    }
    override fun draw(card: Card): State {
        val newHand: HandCards = hand + card
        return when {
            newHand.cards.size == 1 -> Init(newHand)
            newHand.cards.size == 2 && newHand.total() == 21 -> BlackJack(newHand)
            else -> Hit(newHand)
        }
    }

    override fun stay(): State {
        throw IllegalStateException()
    }
}

//Q: Would it make sense to directly call draw twice in the init block when creating an Init object?
//Q: Why do I not pass the whole deck as parameter to draw()?
//Q: Is it not costly to always return new instances of State?
//Q: Mutable handcards vs immutable handcards -> adding a new card always returns a new instance of HandCards
// -> seems costly/inefficient to me, but of course it makes the logic more testable and

