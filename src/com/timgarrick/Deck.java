package com.timgarrick;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void addNewCard(Card card) {
        deckOfCards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deckOfCards);
    }

    public Card takeACardFromTheDeck() {
        return deckOfCards.remove(deckOfCards.size()-1);

    }

/*    public void sort() {
        Collections.sort(deckOfCards,);
    }*/

    public void outputCardDeckToConsole() {
        for (Card card : deckOfCards) {
            System.out.println(card.toString());

        }
    }

}
