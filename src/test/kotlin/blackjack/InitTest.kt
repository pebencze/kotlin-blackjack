package blackjack

import blackjack.model.State
import blackjack.model.Init
import blackjack.model.Hit
import blackjack.model.BlackJack
import blackjack.model.HandCards
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InitTest {
    @Test
    fun `test empty hand`() {
        var state: State = Init()
        assertThat(state.hand.cards.size).isEqualTo(0)
        assertThat(state).isInstanceOf(Init::class.java)
    }

    @Test
    fun `test hand of 3 cards throws IllegalStateException`() {
        val handCards = HandCards(listOf(THREE_CLUBS, THREE_HEARTS, THREE_SPADES))
        assertThrows<IllegalStateException> { val state: State = Init(handCards) }
    }

    @Test
    fun `test drawing one card`() {
        var state: State = Init()
        state = state.draw(ACE_DIAMONDS)
        assertThat(state.hand.cards.size).isEqualTo(1)
        assertThat(state).isInstanceOf(Init::class.java)
    }

    @Test
    fun `test drawing two cards changes state`() {
        var state: State = Init()
        repeat(2) { state = state.draw(SIX_DIAMONDS) }
        assertThat(state.hand.cards.size).isEqualTo(2)
        assertThat(state).isNotInstanceOf(Init::class.java)
    }

    @Test
    fun `test drawing two cards changes state to Hit`() {
        var state: State = Init()
        repeat(2) { state = state.draw(SIX_DIAMONDS) }
        assertThat(state.hand.cards.size).isEqualTo(2)
        assertThat(state).isInstanceOf(Hit::class.java)
    }

    @Test
    fun `test drawing two cards changes state to Blackjack`() {
        var state: State = Init()
        state = state.draw(QUEEN_DIAMONDS)
        state = state.draw(ACE_CLUBS)
        assertThat(state.hand.cards.size).isEqualTo(2)
        assertThat(state).isInstanceOf(BlackJack::class.java)
    }

}
