package warGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author navro
 */
import java.util.ArrayList;
import java.util.List;

public abstract class CardGame {
    protected Deck deck;
    protected List<Player> players;

    public CardGame(int numPlayers) {
        deck = new Deck();
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void startGame() {
        deck.shuffle();
        initializeGame();
        playGame();
        endGame();
    }

    protected abstract void initializeGame();

    protected abstract void playGame();

    protected abstract void endGame();

    protected void dealInitialCards(int numCardsPerPlayer) {
        for (Player player : players) {
            for (int i = 0; i < numCardsPerPlayer; i++) {
                player.drawCard(deck);
            }
        }
    }
}

