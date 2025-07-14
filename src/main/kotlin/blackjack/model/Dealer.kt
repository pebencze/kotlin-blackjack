package blackjack.model

class Dealer(
    override val name: String = "Dealer",
    override var state: State = Init(),
) : Participant() {

    fun shouldDraw(): Boolean {
        return state.hand.total() <= 16
    }

    override fun toString(): String {
        return name
    }
}
