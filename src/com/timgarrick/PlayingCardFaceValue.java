package com.timgarrick;

enum PlayingCardFaceValue {
    ACE("Ace",1),
    TWO("Two",2),
    THREE("Three",3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine",9),
    TEN("Ten",10),
    JACK("Jack",11),
    QUEEN("Queen",12),
    KING("King",13);

    private String friendlyName;
    private int value;

    private PlayingCardFaceValue(String name, int value){
        this.friendlyName = name;
        this.value = value;

    }

    public String getFriendlyName() {
        return this.friendlyName;
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
