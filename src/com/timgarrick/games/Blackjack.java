package com.timgarrick.games;

import com.timgarrick.cards.CardCollection;
import com.timgarrick.cards.CardService;
import com.timgarrick.cards.Player;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private int numberOfPlayers;
    private CardCollection dealer = new CardCollection();
    private List<Player> listOfPlayers = new ArrayList<>();
    private CardService cardService = CardService.getInstance();
    private static final int NUMBER_OF_CARDS = 10;
    private boolean gameIsRunning;

    public Blackjack(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        dealer.setCollectionOfCards(cardService.createListOfCards(NUMBER_OF_CARDS));
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = String.valueOf(i+1);
            Player player = new Player(new CardCollection(), name, 0);
            listOfPlayers.add(player);
        }
    }

    public void run() {
        System.out.println("Dealers cards======");

        //deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player: listOfPlayers) {
                cardService.moveCardToCollection(false, 1, dealer, player.getPlayersCards());
            }
        }

        dealer.outputCardDeckToConsole();
        for (Player player: listOfPlayers) {
            System.out.println("Player: " + player.getName() + "=========");
            player.getPlayersCards().outputCardDeckToConsole();
        }

/*        while(gameIsRunning) {
            dealer.outputCardDeckToConsole();
            for (Player player: listOfPlayers) {
                player.getPlayersCards().outputCardDeckToConsole();
            }
        }*/

    }
    //
}
