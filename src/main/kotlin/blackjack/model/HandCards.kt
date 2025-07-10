package blackjack.model

class HandCards(val cards: MutableList<Card> = mutableListOf()) {
    private var aces: Int = 0
    private var reducedAces: Int = 0
    private var _total: Int = 0
    val total: Int
        get() = _total

    fun add(card: Card) {
        cards.add(card)
        _total += card.rank.value
        checkReduceAceValue(card)
    }

    fun checkReduceAceValue(card: Card) {
        if (card.rank == Rank.ACE) aces++
        if (total > 21 && aces > reducedAces) {
            reducedAces += 1
            _total -= 10
        }
    }

//    fun drawable(): Boolean {
//        return true
//    }
//
//    fun calculateTotal(): Int {
//        return 0
//    }

    operator fun compareTo(other: HandCards): Int {
        return this.total - other.total
    }
}
