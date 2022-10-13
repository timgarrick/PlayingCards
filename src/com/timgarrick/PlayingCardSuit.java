package com.timgarrick;

enum PlayingCardSuit {
    CLUB("Clubs",1),
    DIAMOND("Diamonds",2),
    HEART("Hearts",3),
    SPADE("Spades",4);

    private String friendlyName;
    private int value;

    private PlayingCardSuit(String name, int value) {
        this.friendlyName = name;
        this.value = value;
    }

    public String getFriendlyName() {
        return this.friendlyName;
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
