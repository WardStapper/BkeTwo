package com.pluralsight.bokaei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        BkeTwo spel = new BkeTwo();
       // System.out.println("X begint! Kies een positie die je wilt invullen! Eerst de rij, dan de kolom");
        boolean gewonnen = false;
        boolean opgeven = false;

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
                    //opgeven = spel.opgeven();
                    gewonnen = spel.spelEinde();

                }

                spel.spelerWissel();
                spel.printBord();


            }

        }

        System.out.println("Het spel is afgelopen");
    }


  }




