/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warGame;

/**
 *
 * @author navro
 */
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
