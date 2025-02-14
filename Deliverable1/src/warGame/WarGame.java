/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warGame;

import java.util.Scanner;

/**
 *
 * @author navro
 */

public class WarGame extends CardGame {
    

    public WarGame() {
        super(2); // War is played with 2 players
    }
    private Scanner scanner = new Scanner(System.in);
    @Override
    protected void initializeGame() {
        System.out.println("Starting War Game...");
        dealInitialCards(26); // Each player gets half the deck
        System.out.println(players.get(0).getName() + " and " + players.get(1).getName() + " have been dealt 26 cards each.");
    }

    @Override
    protected void playGame() {
        while (!players.get(0).getHand().getCards().isEmpty() && !players.get(1).getHand().getCards().isEmpty()) {
            System.out.println("\nPress Enter to play the next round or type 'quit' to exit...");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Game ended by user.");
                break; // Exit the game if the user types 'quit'
            }

            Card card1 = players.get(0).getHand().getCards().remove(0);
            Card card2 = players.get(1).getHand().getCards().remove(0);

            System.out.println(players.get(0).getName() + " plays: " + card1);
            System.out.println(players.get(1).getName() + " plays: " + card2);

            int value1 = getCardValue(card1);
            int value2 = getCardValue(card2);

            if (value1 > value2) {
                System.out.println(players.get(0).getName() + " wins the round!");
                players.get(0).getHand().addCard(card1);
                players.get(0).getHand().addCard(card2);
            } else if (value1 < value2) {
                System.out.println(players.get(1).getName() + " wins the round!");
                players.get(1).getHand().addCard(card1);
                players.get(1).getHand().addCard(card2);
            } else {
                System.out.println("It's a tie! Time for WAR!");
                handleWar();
            }
            displayPlayerStatus();
        }
    }

    @Override
    protected void endGame() {
        if (players.get(0).getHand().getCards().isEmpty()) {
            System.out.println(players.get(1).getName() + " wins the game!");
        } else {
            System.out.println(players.get(0).getName() + " wins the game!");
        }
        displayPlayerStatus();
        System.out.println("Thanks for playing!");
    }
    private void displayPlayerStatus() {
        System.out.println("\n--- Player Status ---");
        System.out.println(players.get(0).getName() + " has " + players.get(0).getHand().getCards().size() + " cards.");
        System.out.println(players.get(1).getName() + " has " + players.get(1).getHand().getCards().size() + " cards.");
        System.out.println("---------------------\n");
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

    private void handleWar() {
        System.out.println("Each player places 3 cards face down and flips the 4th card.");
        if (players.get(0).getHand().getCards().size() < 4 || players.get(1).getHand().getCards().size() < 4) {
            System.out.println("Not enough cards for WAR. Ending the game.");
            return;
        }

        // Simulate placing 3 cards face down
        Card[] warCards1 = new Card[3];
        Card[] warCards2 = new Card[3];
        for (int i = 0; i < 3; i++) {
            warCards1[i] = players.get(0).getHand().getCards().remove(0);
            warCards2[i] = players.get(1).getHand().getCards().remove(0);
        }

        // Flip the 4th card
        Card warCard1 = players.get(0).getHand().getCards().remove(0);
        Card warCard2 = players.get(1).getHand().getCards().remove(0);

        System.out.println(players.get(0).getName() + "'s war card: " + warCard1);
        System.out.println(players.get(1).getName() + "'s war card: " + warCard2);

        int warValue1 = getCardValue(warCard1);
        int warValue2 = getCardValue(warCard2);

        if (warValue1 > warValue2) {
            System.out.println(players.get(0).getName() + " wins the WAR!");
            players.get(0).getHand().addCard(warCard1);
            players.get(0).getHand().addCard(warCard2);
            for (Card card : warCards1) players.get(0).getHand().addCard(card);
            for (Card card : warCards2) players.get(0).getHand().addCard(card);
        } else if (warValue1 < warValue2) {
            System.out.println(players.get(1).getName() + " wins the WAR!");
            players.get(1).getHand().addCard(warCard1);
            players.get(1).getHand().addCard(warCard2);
            for (Card card : warCards1) players.get(1).getHand().addCard(card);
            for (Card card : warCards2) players.get(1).getHand().addCard(card);
        } else {
            System.out.println("Another tie! Continuing the WAR...");
            handleWar(); // Recursive call for another WAR
        }
    }
}
