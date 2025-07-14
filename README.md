# Kotlin Blackjack
Welcome to my simple Blackjack card game in Kotlin. I have implemented 
an interactive game following the original Blackjack rules. Players can also bet
some money. here are the rules:

## Rule
Each player must place a bet at the start of the game. <br/>
Card values follow standard Blackjack rules: <br/>
Number cards are counted by their face value.<br/>
Face cards (King, Queen, Jack) are each worth 10.<br/>
Aces can count as either 1 or 11.<br/>
Players are dealt two cards at the beginning of the game.<br/>
Players can choose to draw additional cards as long as their total does not exceed 21.<br/>
If a player draws a card and the total exceeds 21, they lose their entire bet.<br/>
If a player hits 21 with the initial two cards (Blackjack), they receive 1.5x their bet.<br/>
If both the player and dealer have Blackjack, the player’s bet is returned.<br/>
The dealer must draw an additional card if their initial total is 16 or less.<br/>
The dealer must stand on 17 or more.<br/>
If the dealer busts (exceeds 21), all remaining players automatically win and receive payouts based on their bets.<br/>

## State Pattern
This project allows us to implement the so-called State Pattern
and therefore eliminate scattered and excessive conditionals.

Since the game by nature provides states: hit, busted, blackjack, etc. it makes sense to use this pattern for our game.
The State Pattern holds:
1. State Interface 
2. Concrete States 
3. Context (game logic)

## Features
States
- [ ] Hit
  - has to decide if "y" or "n"
  - <= 21 for player (can)
  - <= 16 for dealer (must)
  - {ACTION}
  - -> Hit or Bust or Stay
- [ ] Bust 
  - goes over 21
  - {STOP}
- [ ] Init 
  - has to draw 2 cards
  - {ACTION}
  - -> Hit
- [ ] BlackJack 
  - has exactly 21 with 2 cards
  - {STOP}
- [ ] Stay
  - has <= 21, but decided to stop
  - {STOP}

Context
