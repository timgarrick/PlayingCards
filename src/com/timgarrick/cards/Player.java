package com.timgarrick.cards;

public class Player {
    private CardCollection playersCollection;
    private String name;
    private int score;

    public Player(CardCollection playersCollection, String name, int score) {
        this.playersCollection = playersCollection;
        this.name = name;
        this.score = score;
    }

    public CardCollection getPlayersCollection() {
        return playersCollection;
    }

    public void setPlayersCollection(CardCollection playersCollection) {
        this.playersCollection = playersCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int updateScore(){
        this.score = 0;
        for (Card card: playersCollection.getCollectionOfCards()) {
            this.score += card.cardValue();
        }
        return score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
