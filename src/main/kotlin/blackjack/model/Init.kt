package blackjack.model.states

//Q: Would it make sense to directly call draw twice in the init block when creating an Init object?
//Q: Why do I not pass the whole deck as parameter to draw()?
//Q: Is it not costly to always return new instances of State?
//Q: Mutable handcards vs immutable handcards -> adding a new card always returns a new instance of HandCards
// -> seems costly/inefficient to me, but of course it makes the logic more testable and

