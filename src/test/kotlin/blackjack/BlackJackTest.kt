package blackjack

import blackjack.model.BlackJack
import blackjack.model.HandCards
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BlackJackTest {
    @Test
    fun `test init blackjack with correct cards`(){
        val handCards = HandCards.from(ACE_DIAMONDS, QUEEN_HEARTS)
        assertDoesNotThrow { BlackJack(handCards) }
    }

    @Test
    fun `test init blackjack with wrong cards`(){
        val handCards = HandCards.from(ACE_DIAMONDS, QUEEN_DIAMONDS, QUEEN_SPADES)
        assertDoesNotThrow { BlackJack(handCards) }
    }

    @Test
    fun `test draw throws exception`(){
        val handCards = HandCards.from(ACE_DIAMONDS, QUEEN_DIAMONDS)
        val blackJack = BlackJack(handCards)
        assertThrows<IllegalStateException> { blackJack.draw(TWO_CLUBS) }
        assertThrows<IllegalStateException> { blackJack.stay() }
    }
}
