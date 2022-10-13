package com.timgarrick;

public class Card {
    private int sortValue;
    private PlayingCardSuit cardSuit;
    private PlayingCardFaceValue cardValue;

    public Card(int sortValue, PlayingCardSuit cardSuit, PlayingCardFaceValue cardValue) {
        this.sortValue = sortValue;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return "Card is " + cardValue.getFriendlyName() + " of " + cardSuit.getFriendlyName();
    }
}
