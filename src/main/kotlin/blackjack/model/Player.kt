package blackjack.model

class Player(
    override val name: String,
    override val handCards: HandCards,
): Participant {
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(name.length <= 15) { "Name cannot be longer than 15 chars" }
        require(name.all { it.isLetter() }) { "Name must contain only letters" }
    }
}