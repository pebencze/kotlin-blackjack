package blackjack.controller

import blackjack.model.HandCards
import blackjack.view.InputView
import blackjack.model.Player

class Controller {
    fun initializePlayers() {
        val playerNames = InputView.readNames()
        val players = playerNames.map{ Player(it, HandCards()) }
    }
}