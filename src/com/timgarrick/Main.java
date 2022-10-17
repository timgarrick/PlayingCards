package com.timgarrick;

import com.timgarrick.games.Blackjack;
import com.timgarrick.games.War;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        //Blackjack blackjack = new Blackjack(3);
        War war = new War();

        war.run();
        //blackjack.run();

    }

}
