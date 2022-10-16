package com.timgarrick.games;

import com.timgarrick.cards.Card;
import com.timgarrick.cards.CardCollection;
import com.timgarrick.cards.CardService;
import com.timgarrick.cards.Player;
import com.timgarrick.controller.ConsoleInterface;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private static final int NUMBER_OF_CARDS_IN_A_DECK = 52;
    private static final int NUMBER_OF_DECKS_IN_GAME = 6;

    private int numberOfOtherPlayers;
    private CardService cardService = CardService.getInstance();
    private CardCollection allCardsInGame = new CardCollection();
    private List<Player> listOfPlayers = new ArrayList<>();
    private ConsoleInterface console = new ConsoleInterface();

    private boolean gameIsRunning = false;

    public Blackjack(int numberOfOtherPlayers) {
        //Initialise our game
        allCardsInGame.setCollectionOfCards(cardService.createListOfCards(NUMBER_OF_CARDS_IN_A_DECK
                                                                                        * NUMBER_OF_DECKS_IN_GAME));
        this.numberOfOtherPlayers = numberOfOtherPlayers;

        //create dealer
        Player dealer = new Player(new CardCollection(), "Dealer",0);
        listOfPlayers.add(dealer);

        //create player
        Player player = new Player(new CardCollection(), console.getNextString("Enter your name: "), 0);
        listOfPlayers.add(player);

        //create other plays
        if(numberOfOtherPlayers > 0){
            for (int i = 0; i < numberOfOtherPlayers; i++) {
                String name = "Player " + (i+1);
                Player otherPlayers = new Player(new CardCollection(), name, 0);
                listOfPlayers.add(otherPlayers);
            }
        }

    }

    public void run() {
        gameIsRunning = true;
        allCardsInGame.shuffle();
        int inputValue = 0;
        //allCardsInGame.outputCardDeckToConsole();

        while(gameIsRunning) {
            boolean playerLoop = true;
            boolean dealerLoop = true;
            //game loop
            //deal 2 to everyome
            console.outputText("Dealer deals 2 cards to all players");
            cardService.dealCards(2,allCardsInGame,listOfPlayers);
            console.outputGameStateToConsole(listOfPlayers);
            updateScore();

            while(playerLoop) {
                inputValue = console.getNextInt("Type 1 to hit, 2 to stick, 5 to quit");

                switch (inputValue) {
                    case 1: {
                        cardService.moveCardToCollection(1,allCardsInGame,listOfPlayers.get(1).getPlayersCollection());
                        updateScore();
                        console.outputText("Your score is: " + listOfPlayers.get(1).getScore());
                        console.outputGameStateToConsole(listOfPlayers);

                        System.out.println(listOfPlayers.get(1).getScore());
                        if (listOfPlayers.get(1).getScore() > 21) {
                            console.outputText("You scored over 21, you lost!");
                            playerLoop = false;
                            gameIsRunning = false;
                        }
                        break;

                    }
                    case 2: {
                        console.outputText("Sticking on " + listOfPlayers.get(1).getScore());
                        playerLoop = false;
                        break;
                    }
                    case 5: {
                        playerLoop = false;
                        gameIsRunning = false;
                        break;
                    }
                }
            }

            while(dealerLoop) {
                if(listOfPlayers.get(0).getScore() < 18) {
                    console.outputText("Dealer must draw a card");
                    cardService.moveCardToCollection(1,allCardsInGame,listOfPlayers.get(0).getPlayersCollection());
                    updateScore();
                    console.outputGameStateToConsole(listOfPlayers);
                } else if(listOfPlayers.get(0).getScore() >=18 && listOfPlayers.get(0).getScore() < 21) {
                    console.outputText("Dealer sticks on" + listOfPlayers.get(0).getScore());
                    console.outputGameStateToConsole(listOfPlayers);
                    dealerLoop = false;
                } else if(listOfPlayers.get(0).getScore() == 21) {
                    console.outputText("Dealer hits blackjack. Dealer wins");
                    dealerLoop = false;
                    gameIsRunning = false;
                } else {
                    console.outputText("Dealer is bust. You win");
                    dealerLoop = false;
                    gameIsRunning = false;
                }
            }

            console.outputText("Dealer score: " + listOfPlayers.get(0).getScore());
            console.outputText("Your score: " + listOfPlayers.get(1).getScore());
        }
    }

    private void updateScore() {
        for (Player player:listOfPlayers) {
            player.setScore(blackjackCardCollectionScore(player));
        }
    }

    private int blackjackCardCollectionScore(Player player)
    {
        int score = 0;

        for (Card card: player.getPlayersCollection().getCollectionOfCards()) {
            if(card.cardValue() == 11 || card.cardValue() == 12 || card.cardValue() == 13)
            {
                score += 10;
            } else {
                score += card.cardValue();
            }
        }
        return score;
    }
}
