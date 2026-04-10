# TicTacToe

- Think in terms of hardware game to explain interview
- 3x3 grid
- two players take turns marking spaces X & O
  - one player gets 3 of their marks in a row
  - grid is completely filled, resulting a draw

## Clarify Requirements

- standard 3x3
- two player human player
- provides move validate
- detects win or draw conditions

## Identifying key components

- Symbol
- Baord
- Player

## Design Challenges
- Tell a design pattern even though you can't implement
- Manging Game state
  - ensuring system accurately tracks
    - player turns
    - current baord status
    - game completion conditions
- Implementingt Move validation
  - Verifying that each move is:
    - legal
    - within the bounds of game
    - made in an empty cell
- TRacking Player turns
  - ensuring proper alternation
    - between 'X' and 'O' after each valid move
- Detecting Game Ending Conditions
  - Checking for
    - Win conditions
    - A draw scenario

## Effective Design Pattern
- STrategy Pattern for player Interactions
  - ensures players interact with system through a consistent interface
  - allows flexible player move implementation, supporting Human players, AI players(future expansion)
- State pattern for game flow management
  - manges diff. game states
    - in-progress, won, draw
- Observer Pattern for Game event tracking
  - notifies listeners when game state chanegs
  - supports potential future extensions(like logging, notifications or UI updtaes)
- Factory Pattern for player creation
  - Ensures consistent players creation using a factory method
  - allows easy addition of new player types(AI opponents)
