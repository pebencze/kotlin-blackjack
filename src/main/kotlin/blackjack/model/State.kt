
package blackjack.model

interface State {
    val hand: HandCards
    fun draw(card: Card): State
    fun stay(): State
}
