package blackjack.model

class Player(
    override val name: String,
    override var state: State = Init(),
    var bet: Bet = Bet.UNPLACED,
) : Participant() {
    init {
        require(name.isNotBlank()) { ErrorMessage.NAME_BLANK.toString() }
        require(name.length <= 15) { ErrorMessage.NAME_LENGTH.toString() }
        require(name.all { it.isLetter() }) { ErrorMessage.NAME_LETTERS.toString() }
    }

    override fun toString(): String {
        return name
    }
}
