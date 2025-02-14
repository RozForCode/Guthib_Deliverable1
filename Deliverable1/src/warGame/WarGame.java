/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warGame;

/**
 *
 * @author navro
 */
public class WarGame extends CardGame {

    public WarGame() {
        super(2); // War is played with 2 players
    }

    @Override
    protected void initializeGame() {
        System.out.println("Starting War Game...");
        dealInitialCards(26); // Each player gets half the deck
    }

    @Override
    protected void playGame() {
        while (!players.get(0).getHand().getCards().isEmpty() && !players.get(1).getHand().getCards().isEmpty()) {
            Card card1 = players.get(0).getHand().getCards().remove(0);
            Card card2 = players.get(1).getHand().getCards().remove(0);

            System.out.println(players.get(0).getName() + " plays: " + card1);
            System.out.println(players.get(1).getName() + " plays: " + card2);

            if (getCardValue(card1) > getCardValue(card2)) {
                System.out.println(players.get(0).getName() + " wins the round!");
                players.get(0).getHand().addCard(card1);
                players.get(0).getHand().addCard(card2);
            } else if (getCardValue(card1) < getCardValue(card2)) {
                System.out.println(players.get(1).getName() + " wins the round!");
                players.get(1).getHand().addCard(card1);
                players.get(1).getHand().addCard(card2);
            } else {
                System.out.println("It's a tie! Cards go back to the deck.");
            }
        }
    }

    @Override
    protected void endGame() {
        if (players.get(0).getHand().getCards().isEmpty()) {
            System.out.println(players.get(1).getName() + " wins the game!");
        } else {
            System.out.println(players.get(0).getName() + " wins the game!");
        }
    }

    private int getCardValue(Card card) {
        String rank = card.getRank();
        switch (rank) {
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                return Integer.parseInt(rank);
        }
    }
}
