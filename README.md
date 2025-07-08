# kotlin-blackjack
Card values follow standard Blackjack rules:
Number cards are counted by their face value.
Face cards (King, Queen, Jack) are each worth 10.
Aces can be worth either 1 or 11.
Each player starts with two cards.
Players may draw additional cards as long as their total remains 21 or less.
The dealer must draw a card if their total is 16 or less, and must stand on 17 or more.
If the dealer busts (goes over 21), all remaining players automatically win.
After the game ends, display the result (win/loss) for each player.

Enter the names of the players (comma-separated):
pobi,jason

Dealing two cards to dealer, pobi, jason.
Dealer: 3♦
pobi's cards: 2♥, 8♠
jason's cards: 7♣, K♠

Would pobi like to draw another card? (y for yes, n for no)
y
pobi's cards: 2♥, 8♠, A♣
Would pobi like to draw another card? (y for yes, n for no)
n
Would jason like to draw another card? (y for yes, n for no)
n
jason's cards: 7♣, K♠

Dealer draws one more card due to having 16 or less.

Dealer's cards: 3♦, 9♣, 8♦ – Total: 20
pobi's cards: 2♥, 8♠, A♣ – Total: 21
jason's cards: 7♣, K♠ – Total: 17

Final Results
Dealer: 1 Win 1 Lose
pobi: Win
jason: Lose

## Features
- [ ] get user input for player names
  - [ ] MIN (1), MAX(7) excluding dealer
  - [ ] names can contain only letters
  - [ ] MAX..MIN length
  - [ ] comma separated
- [ ] display names 

- [ ] deal initial cards to player and dealer (participants)
  - [ ] 2 per player
- [ ] print cards
  - [ ] for the dealer only 1
  - [ ] for players all
  - [ ] color and value

- [ ] prompt each player for drawing cards
  - [ ] until "n"
  - [ ] until he is busted
- [ ] draw cards
- [ ] calculate sum
- [ ] display cards of player

- [ ] draw cards for dealer until sum is <= 16
- [ ] display message

- [ ] display cards
- [ ] display sum

- [ ] calculate results
  - [ ] player 
  - [ ] dealer 
- [ ] display results

  




