package com.timgarrick.cards;

import java.util.ArrayList;

public class Card {
    private int cardIndex;
    private PlayingCardSuit cardSuit;
    private PlayingCardFaceValue cardValue;

    public Card(int cardIndex, PlayingCardSuit cardSuit, PlayingCardFaceValue cardValue) {
        this.cardIndex = cardIndex;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public int cardValue(){
        return cardValue.getValue();
    }

    @Override
    public String toString() {
        return cardValue.getShortName() + cardSuit.getIcon();
    }
}
