package com.timgarrick.cards;

import java.util.ArrayList;
import java.util.Collections;

public class CardCollection {
    private ArrayList<Card> collectionOfCards = new ArrayList<>();

    public ArrayList<Card> getCollectionOfCards() {
        return collectionOfCards;
    }

    public void setCollectionOfCards(ArrayList<Card> collectionOfCards) {
        this.collectionOfCards = collectionOfCards;
    }

    public void addNewCard(Card card) {
        collectionOfCards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(collectionOfCards);
    }

    public Card takeACardFromTheDeck() {
        return collectionOfCards.remove(collectionOfCards.size()-1);
    }

/*    public void sort() {
        Collections.sort(deckOfCards,);
    }*/
    public void outputCardDeckToConsole() {
        for (Card card : collectionOfCards) {
            System.out.println(card.toString());

        }
    }

/*    public int getValueOfCards()
    {
        int total = 0;
        for (Card card:collectionOfCards) {
            total += card.cardValue();
        }

        return total;
    }*/

}
