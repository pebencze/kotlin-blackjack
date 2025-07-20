package blackjack.model

import blackjack.model.states.State

abstract class Participant {
    abstract val name: String
    abstract var state: State
}
