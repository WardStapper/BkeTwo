package com.pluralsight.bokaei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Welkom bij het spel Boter-Kaas-Eieren!");
        BkeTwo spel = new BkeTwo();
        System.out.println("X begint! Kies een positie die je wilt invullen! Eerst de rij, dan de kolom");
        boolean gewonnen = false;

        while(!gewonnen) {
            System.out.println("Kies je volgende zet!");
            spel.printBord();
            int rij;
            int kol;

            while(!gewonnen) {
                boolean gezet = false;
                while(!gezet){
                    System.out.println("Speler" + spel.getSpeler() + ", kies je volgende zet!");
                    rij = spel.valideerInput(sc.next()) - 1;
                    kol = spel.valideerInput(sc.next()) - 1;
                    gezet = spel.spelerZet(rij,kol);
                    //System.out.println(gewonnen);
                    spel.printBord();
                    gewonnen = spel.spelEinde();
                    spel.spelerWissel();
                }
            }
           // while (!spel.spelerZet(rij, kol) && !gewonnen);
        }

        //spel.printBord();
        System.out.println("Het spel is afgelopen");
    }

  }




