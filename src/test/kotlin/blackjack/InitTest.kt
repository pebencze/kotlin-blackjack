package blackjack

import blackjack.model.State
import blackjack.model.Init
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InitTest {
    @Test
    fun `test empty hand`() {
        var state: State = Init()
        assertThat(state.hand.cards.size).isEqualTo(0)
        assertThat(state).isInstanceOf(Init::class.java)
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

}
