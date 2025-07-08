package blackjack.view

object InputView {
    fun readNames(): List<String> {
        println("\nEnter the names of the players (comma-separated):")
        val input = readln()
        if (input.isEmpty()) {
            throw IllegalArgumentException("input is empty")
        }
        return input.split(",").map { it.trim() }
    }


}