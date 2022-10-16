package com.timgarrick.controller;

import com.timgarrick.cards.Player;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    Scanner scanner = new Scanner(System.in);


    public String getNextString(String string){
        System.out.println(string);
        return scanner.nextLine();
    }

    public int getNextInt(String string){
        System.out.println(string);

        while(!scanner.hasNextInt()){
            System.out.println("Please enter a valid number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    public void outputText(String string) {
        System.out.println(string);
    }

    public void outputGameStateToConsole(List<Player> allPlayersInGame) {
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("   Dealers hand: " + allPlayersInGame.get(0).getPlayersCollection().getCollectionOfCards().toString());
        System.out.println("");
        System.out.println("   Your hand: " + allPlayersInGame.get(1).getPlayersCollection().getCollectionOfCards().toString());
        System.out.println("");
    }
}
