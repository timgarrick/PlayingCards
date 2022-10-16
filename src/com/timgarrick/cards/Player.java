package com.timgarrick.cards;

public class Player {
    private CardCollection playersCards;
    private String name;
    private int score;

    public Player(CardCollection playersCards, String name, int score) {
        this.playersCards = playersCards;
        this.name = name;
        this.score = score;
    }

    public CardCollection getPlayersCards() {
        return playersCards;
    }

    public void setPlayersCards(CardCollection playersCards) {
        this.playersCards = playersCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
