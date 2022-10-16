package com.timgarrick.tests;

import com.timgarrick.cards.*;
import org.junit.jupiter.api.Test;

public class PlayingCardsTests {
    @Test
    void createDeckAndPickRandomCard()
    {
        final int NUMBER_OF_CARDS = 52;
        CardCollection myCardCollectionOfCards = new CardCollection();
        CardCollection myCardCollectionOfRandomCards = new CardCollection();
        CardService cardService = CardService.getInstance();

        //Create our cards
        myCardCollectionOfCards.setCollectionOfCards(cardService.createListOfCards(52));

        cardService.moveCardToCollection(false, 1, myCardCollectionOfCards, myCardCollectionOfRandomCards);

        System.out.println("=Original CardCollection of cards=======");
        myCardCollectionOfCards.outputCardDeckToConsole();
        System.out.println("=New CardCollection of random cards=======");
        myCardCollectionOfRandomCards.outputCardDeckToConsole();

    }

}
