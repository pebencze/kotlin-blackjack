package blackjack

import blackjack.model.Init

class InitTest {
    @Test
    fun `test drawing one card`() {
        val init = Init()
        init.draw()
        asserThat(init.hand.cards.size).isEqualTo(1)
        assertThat(init).isInstanceOf(Init::class.java)
    }

    fun `test drawing two cards`() {
        val init = Init()
        repeat(2) init.draw()
        asserThat(init.hand.cards.size).isEqualTo(2)
        assertThat(init).isInstanceOf(Init::class.java)
    }

    fun `test drawing third card changes state to Hit`() {
        val init = Init()
        repeat(3) init.draw()
        assertThat(init).isInstanceOf(Hit::class.java)
        asserThat(init.hand.cards.size).isEqualTo(3)
    }
}
