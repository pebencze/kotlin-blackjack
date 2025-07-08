package blackjack

import blackjack.model.CardDeck
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeckTest {

    @Test
    fun `test number of cards in deck`(){
        assertEquals(CardDeck().deck.size, 52)
    }
}