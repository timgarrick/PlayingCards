package com.timgarrick.cards;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private static CardService instance = null;

    CardService() {
    }

    public static CardService getInstance() {
        if (instance == null) {
            instance = new CardService();
        }
        return instance;
    }

    public ArrayList<Card> createListOfCards(int numberOfCards) {
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            cardList.add(cardGenerator(i));
        }
        return cardList;
    }

    public Card viewCardOnBottomOfDeck(CardCollection cardCollection) {
        return cardCollection.getCollectionOfCards().get(cardCollection.getCollectionOfCards().size()-1);
    }

    public void moveCardToCollection(int numberOfCardsToPick, CardCollection originalCollection, CardCollection newCollection) {
        for (int i = 0; i < numberOfCardsToPick; i++) {
            Card card = originalCollection.getCollectionOfCards().remove(originalCollection.getCollectionOfCards().size()-1);
            newCollection.addNewCard(card);
        }
    }

    public void moveAllCardsToCollection(CardCollection originalCollection, CardCollection newCollection) {
        for (Card card:originalCollection.getCollectionOfCards()) {
            newCollection.getCollectionOfCards().add(originalCollection.getCollectionOfCards()
                                                .remove(originalCollection.getCollectionOfCards().size()-1));

        }
    }

    public void dealCards(int numberOfCardsToDeal, CardCollection allCardsInGame, List<Player> listOfPlayers) {
        for (int i = 0; i < numberOfCardsToDeal; i++) {
            for (Player player : listOfPlayers) {
                moveCardToCollection(1, allCardsInGame, player.getPlayersCollection());
            }
        }
    }

    //Method to build a card based on an input value, ie 1 = Ace of Clubs, 52 = King of Spades, 53 = ace of clubs again
    private Card cardGenerator(int generateCardIndex) {
        int numberOfFaceCards = PlayingCardFaceValue.values().length;
        int numberOfSuits = PlayingCardSuit.values().length;

        //If there's more cards than total suits * total number of face cards, we need to rollover back to 1
        generateCardIndex = generateCardIndex % (numberOfFaceCards * numberOfSuits);

        return new Card(generateCardIndex, PlayingCardSuit.fromValue(generateCardIndex / numberOfFaceCards),
                PlayingCardFaceValue.fromValue(generateCardIndex % numberOfFaceCards));
    }


}
