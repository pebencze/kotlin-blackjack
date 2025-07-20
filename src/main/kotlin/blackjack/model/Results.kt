package blackjack.model

import blackjack.model.states.BlackJack
import blackjack.model.states.Bust

class Results(private val dealer: Dealer, private val players: Players){
    fun playerResult(player: Player): Double {
        // Bust
        if (player.state is Bust) return player.state.profit(player.bet.amount)
        if (dealer.state is Bust) return player.state.profit(player.bet.amount)

        // BlackJack
        if (dealer.state is BlackJack && player.state is BlackJack) return 0.0
        if (dealer.state is BlackJack) return player.bet.amount * -1.0
        if (player.state is BlackJack) return player.state.profit(player.bet.amount)

        // Stay
        return when {
            dealer.state.hand > player.state.hand -> player.bet.amount * -1.0
            dealer.state.hand < player.state.hand -> player.state.profit(player.bet.amount)
            else -> 0.0
        }
    }

    fun playersResult(): Double {
        var sum = 0.0
        players.forEach { sum += playerResult(it) }
        return sum
    }

    fun dealerResult(): Double {
        return playersResult() * -1.0
    }
}
