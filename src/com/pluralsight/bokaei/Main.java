package com.pluralsight.bokaei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        BkeTwo spel = new BkeTwo();
        boolean gewonnen = false;
        boolean gelijkspel = false;


            while((!gewonnen) && (!gelijkspel)) {
                int rij;
                int kol;
                boolean gezet = false;

                while(!gezet){
                    System.out.println("Speler" + spel.getSpeler() + ", kies je volgende zet!");
                    rij = spel.valideerInput(sc.next()) - 1;
                    kol = spel.valideerInput(sc.next()) - 1;
                   gezet = spel.spelerZet(rij,kol);
                   gewonnen = spel.checkWinst();


                }

                spel.spelerWissel();
                gelijkspel = spel.gelijkSpel();


               // spel.opgeven();
                spel.printBord();
              }

        System.out.println("Het spel is afgelopen");
    }


  }




