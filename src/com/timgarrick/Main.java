package com.timgarrick;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUMBER_OF_CARDS = 52;

    public static void main(String[] args) {
        final int NUMBER_OF_CARDS = 52;
        Deck myDeckOfCards = new Deck();
        Deck myDeckOfRandomCards = new Deck();

        //Create our cards
        myDeckOfCards.setDeckOfCards(createListOfCards());

        pickRandomCards(10, myDeckOfCards, myDeckOfRandomCards);

        System.out.println("=Original Deck of cards=======");
        myDeckOfCards.outputCardDeckToConsole();
        System.out.println("=New Deck of random cards=======");
        myDeckOfRandomCards.outputCardDeckToConsole();

    }

    private static ArrayList<Card> createListOfCards() {
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            cardList.add(cardGenerator(i));
        }
        return cardList;
    }


    //Method to build a card based on an input value, ie 1 = Ace of Clubs, 52 = King of Spades, 53 = ace of clubs again
    public static Card cardGenerator(int i) {
        int numberOfFaceCards = PlayingCardFaceValue.values().length;
        int numberOfSuits = PlayingCardSuit.values().length;

        //If theres more cards than total suits * total number of face cards, we need to rollover back to 1
        i = i % (numberOfFaceCards * numberOfSuits);

        return new Card(i, PlayingCardSuit.fromValue(i / numberOfFaceCards),
                           PlayingCardFaceValue.fromValue(i % numberOfFaceCards));
    }

    public static void pickRandomCards(int numberOfCardsToPick, Deck originalDeck, Deck newDeck) {
        originalDeck.shuffle();
        for (int i = 0; i < numberOfCardsToPick; i++) {
            newDeck.addNewCard(originalDeck.takeACardFromTheDeck());
        }
    }

}
