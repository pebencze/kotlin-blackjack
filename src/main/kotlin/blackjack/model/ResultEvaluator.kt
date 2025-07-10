package blackjack.model

data class DealerResult(var wins: Int = 0, var losses: Int = 0, var draws: Int = 0) {
    override fun toString(): String {
        return "Dealer: $wins wins, $losses losses, $draws draws"
    }
}
data class PlayerResult(var win: Boolean = false, var draw: Boolean = false, val name: String = "") {
    override fun toString(): String {
        if (win) return "$name: win"
        if (draw) return "$name: draw"
        return "$name: loss"
    }
}

class ResultEvaluator(val players: Players, val dealer: Dealer) {
    var dealerResult: DealerResult = DealerResult()
    var playerResults: MutableList<PlayerResult> = mutableListOf()
    init {
        calculateDealerResults()
        calculateAllPlayersResults()
    }

    fun calculateDealerResults() {
        if (dealer.isBusted()) {
            dealerResult.losses = players.players.count() { it.isNotBusted() }
            return
        }
        players.forEach {
            compareDealerToPlayer( it )
        }
    }

    fun compareDealerToPlayer(player: Player) {
        if (player.isBusted()){
            dealerResult.wins++
        }
        if (player.isNotBusted()) {
            when {
                player.handCards.total < dealer.handCards.total -> dealerResult.wins++
                player.handCards.total > dealer.handCards.total -> dealerResult.losses++
                else -> dealerResult.draws++
            }
        }
    }

    fun calculateAllPlayersResults() {
        players.forEach { playerResults.add(calculatePlayerResult(it)) }
    }

    fun calculatePlayerResult(player: Player): PlayerResult {
        if (player.isBusted())
            return PlayerResult(name = player.name)
        if (dealer.isBusted())
            return PlayerResult(win = true, name = player.name)
        return when {
            player.handCards.total < dealer.handCards.total -> PlayerResult(name = player.name)
            player.handCards.total > dealer.handCards.total -> PlayerResult(win = true, name = player.name)
            else -> PlayerResult(draw = true, name = player.name)
        }
    }

    //DEALER
    // isNotBusted()
    // -> compare against each player
    // -> player.isBusted() -> win
    // -> player.isNotBusted() -> compare totals (win or loss)
    // isBusted() -> players.size * loss, 0 win
    //PLAYERS
    // isBusted() -> loss
    // Dealer isNotBusted() -> compare (loss or win)
    // Dealer isBusted() -> win
}