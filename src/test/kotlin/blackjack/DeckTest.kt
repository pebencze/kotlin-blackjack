package blackjack

import blackjack.model.CardDeck
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeckTest {
    @Test
    fun `test number of cards in deck`()  {
        assertEquals(CardDeck().deck.size, 52)
    }

    @Test
    fun `test size of deck`()  {
        val deck1 = CardDeck()
        assertEquals(deck1.size, 52)
    }

    @Test
    fun `test hit function`()  {
        val deck1 = CardDeck()
        deck1.hit()
        val deck2 = CardDeck()
        assertEquals(deck1.size, deck2.size - 1)
    }
}
