package blackjack.view

import blackjack.model.Player

object InputView {
    fun readNames(): List<String> {
        println("\nEnter the names of the players (comma-separated):")
        val input = readln()
        if (input.isEmpty()) {
            throw IllegalArgumentException("input is empty")
        }
        return input.split(",").map { it.trim() }
    }

    // TODO validation outside??
    fun promptForDraw(player: Player): Boolean {
        println("Would ${player.name} like to draw another card? (y for yes, n for no)")
        val input = readln().trim()
        if (input.isEmpty()) {
            throw IllegalArgumentException("input is empty")
        }
        return when (input) {
            YES -> true
            NO -> false
            else -> throw IllegalArgumentException("input is invalid")
        }
    }

    private const val YES = "y"
    private const val NO = "n"
}
