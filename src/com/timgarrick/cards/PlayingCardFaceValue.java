package com.timgarrick.cards;

public enum PlayingCardFaceValue {
    ACE("Ace", "A",1),
    TWO("Two","2",2),
    THREE("Three","3",3),
    FOUR("Four","4",4),
    FIVE("Five","5",5),
    SIX("Six","6",6),
    SEVEN("Seven","7",7),
    EIGHT("Eight","8",8),
    NINE("Nine","9",9),
    TEN("Ten","10",10),
    JACK("Jack","J",11),
    QUEEN("Queen","Q",12),
    KING("King","K",13);

    private final String friendlyName;
    private final String shortName;
    private final int value;

    private PlayingCardFaceValue(String name1, String name2, int value){
        this.friendlyName = name1;
        this.shortName = name2;
        this.value = value;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public static PlayingCardFaceValue fromValue(int inputValue) {
        for (PlayingCardFaceValue cardValues: values()) {
            if(cardValues.value == inputValue+1) {
                return cardValues;
            }
        }
        return null;
    }

}
