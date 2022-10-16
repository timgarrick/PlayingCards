package com.timgarrick.cards;

public enum PlayingCardSuit {
    CLUB("Clubs","♧",1),
    DIAMOND("Diamonds","♢",2),
    HEART("Hearts","♡",3),
    SPADE("Spades","♤",4);

    private String friendlyName;
    private String icon;
    private int value;

    private PlayingCardSuit(String name, String icon, int value) {
        this.friendlyName = name;
        this.icon = icon;
        this.value = value;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public String getIcon() {
        return this.icon;
    }

    public static PlayingCardSuit fromValue(int inputValue) {
        for (PlayingCardSuit cardSuit: values()) {
            if(cardSuit.value == inputValue+1) {
                return cardSuit;
            }
        }
        return null;
    }
}
