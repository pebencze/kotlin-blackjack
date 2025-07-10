package blackjack.view

import blackjack.model.ErrorMessage
import blackjack.model.Player
import blackjack.model.PromptMessage

object InputView {
    fun readNames(): List<String> {
        println(PromptMessage.PLAYER_NAMES)
        val input = readln()
        if (input.isEmpty()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString())
        }
        return input.split(",").map { it.trim() }
    }

    fun promptForDraw(player: Player): Boolean {
        println("\nWould ${player.name} like to draw another card? (y for yes, n for no)")
        val input = readln().trim()
        if (input.isEmpty()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString())
        }
        return when (input) {
            YES -> true
            NO -> false
            else -> throw IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString())
        }
    }

    private const val YES = "y"
    private const val NO = "n"
}
