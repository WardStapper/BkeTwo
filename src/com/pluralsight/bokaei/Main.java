package com.pluralsight.bokaei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Welkom bij het spel Boter-Kaas-Eieren!");
        BkeTwo spel = new BkeTwo();
        //spel.printBord();
        //spel.startBord();
        System.out.println("X begint! Kies een positie die je wilt invullen! Eerst de rij, dan de kolom");


        do {
            System.out.println("Kies je volgende zet!");
            spel.printBord();
            int rij;
            int kol;
            do {
                System.out.println("Speler" + spel.getSpeler() + ", kies je volgende zet!");
                rij = sc.nextInt() - 1;
                kol = sc.nextInt() - 1;
            }
            while (!spel.spelerZet(rij, kol));
            spel.spelerWissel();
        }
        while(!spel.testJoekoe());


    }
}




