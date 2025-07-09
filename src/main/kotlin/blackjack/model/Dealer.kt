package blackjack.model

class Dealer(
    override val name: String = "Dealer",
    override var handCards: HandCards = HandCards(),
) : Participant {

    override fun toString(): String {
        return name
    }
}
