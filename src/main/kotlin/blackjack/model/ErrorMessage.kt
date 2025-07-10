package blackjack.model

import blackjack.controller.Controller

enum class ErrorMessage(val message: String) {
    MAX_TRIES("Maximum tries of ${Controller.MAX_TRIES} reached."),
    PLAYER_RANGE("Only ${Players.MIN} - ${Players.MAX} players accepted"),
    ;

    override fun toString() = "[ERROR] $message"
}
