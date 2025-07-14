package blackjack.model

abstract class Participant {
    abstract val name: String
    abstract var state: State
}
