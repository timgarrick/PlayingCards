package com.timgarrick;

import com.timgarrick.games.Blackjack;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("🂡");
        Blackjack blackjack = new Blackjack(3);
        blackjack.run();

    }

}
