package com.timgarrick;

public class Main {

    public static void main(String[] args) {
        final int NUMBER_OF_CARDS = 52;
        Deck myDeckOfCards = new Deck();
        Deck myDeckOfRandomCards = new Deck();

        //Create our cards
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            myDeckOfCards.addNewCard(cardGenerator(i));
        }

        pickRandomCards(1, myDeckOfCards, myDeckOfRandomCards);

        System.out.println("=Original Deck of cards=======");
        myDeckOfCards.outputCardDeckToConsole();
        System.out.println("=New Deck of random cards=======");
        myDeckOfRandomCards.outputCardDeckToConsole();

    }

    //Method to build a card based on an input value, ie 1 = Ace of Clubs, 52 = King of Spades, 53 = ace of clubs again
    public static Card cardGenerator(int i) {

        //If theres more cards than total suits * total number of face cards, we need to rollover back to 1
        i = i % (PlayingCardFaceValue.values().length * PlayingCardSuit.values().length);

        return new Card(i, PlayingCardSuit.fromValue(i/13), PlayingCardFaceValue.fromValue(i%13));
    }

    public static void pickRandomCards(int numberOfCardsToPick, Deck originalDeck, Deck newDeck) {
        originalDeck.shuffle();
        for (int i = 0; i < numberOfCardsToPick; i++) {
            newDeck.addNewCard(originalDeck.takeACardFromTheDeck());
        }
    }

}
