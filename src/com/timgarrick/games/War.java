package com.timgarrick.games;

import com.timgarrick.cards.Card;
import com.timgarrick.cards.CardCollection;
import com.timgarrick.cards.CardService;
import com.timgarrick.cards.Player;
import com.timgarrick.controller.ConsoleInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class War {
    private static final int NUMBER_OF_CARDS_IN_A_DECK = 52;
    private static final int NUMBER_OF_DECKS_IN_GAME = 1;

    private CardService cardService = CardService.getInstance();
    private CardCollection allCardsInGame = new CardCollection();
    private CardCollection clashPile = new CardCollection();
    private List<Player> listOfPlayers = new ArrayList<>();
    private ConsoleInterface console = new ConsoleInterface();

    private boolean gameIsRunning = false;

    public War() {
        allCardsInGame.setCollectionOfCards(cardService.createListOfCards(NUMBER_OF_CARDS_IN_A_DECK
                * NUMBER_OF_DECKS_IN_GAME));

        Player ai = new Player(new CardCollection(), "AI", 0);
        listOfPlayers.add(ai);
        Player player = new Player(new CardCollection(), console.getNextString("Enter your name"), 0);
        listOfPlayers.add(player);

    }

    public void run(){
        gameIsRunning = true;
        allCardsInGame.shuffle();

        cardService.dealCards(NUMBER_OF_CARDS_IN_A_DECK, allCardsInGame, listOfPlayers);

        while(gameIsRunning){
            clash(listOfPlayers);
            console.outputPlayerStateToConsole(listOfPlayers);

        }

    }

    private void clash(List<Player> players) {
        for (Player player: players) {
            if(player.getPlayersCollection().getCollectionOfCards().size() == 0) {
                gameIsRunning = false;
            } else {
                player.setScore(cardService.viewCardOnBottomOfDeck(player.getPlayersCollection()).cardValue());
                cardService.moveCardToCollection(1, player.getPlayersCollection(), clashPile);
            }
        }
        cardService.moveAllCardsToCollection(clashPile,calculateWinner(listOfPlayers).getPlayersCollection());
    }

    private Player calculateWinner(List<Player> listOfPlayers) {

        listOfPlayers.sort(Comparator.comparing(Player::getScore));

        for (Player player: listOfPlayers) {
            player.setScore(0);
        }

        return listOfPlayers.get(0);
    }


}
