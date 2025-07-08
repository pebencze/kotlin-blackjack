package blackjack.model

data class Players(val players: List<Player>) {
    init {
        require(players.size in MIN..MAX) { ErrorMessage.PLAYER_RANGE.message }
    }

    companion object {
        const val MIN = 1
        const val MAX = 6
    }
}
