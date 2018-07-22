package com.pluralsight.bokaei;

import java.util.Scanner;

public class BkeTwo {

    //*********Ervoor zorgen dat wissepeler niet kan plaatsvinden als er een invalid zet wordt gedaan moet iets met spelerzet  doen. Dus als spelerzet == true -> spelerwissel

    //Classvariabelen neerzetten, private
    //count neerzetten om ervoor te zorgen dat het spel na 9 zetten niet kan doorgaan. (gelijkspel e.d.)

    //public static int rij, kol;
    public static Scanner sc = new Scanner(System.in);
    private String[][] bord;
    private String speler;
    private int count = 0;

    //Constructor zorgt voor eerste opzet van het bord
    public BkeTwo() {
        bord = new String[3][3];
        speler = "_X_|";
        startBord();
    }

    //Zorgt voor de eerste weergave van het bord
    //Zorgt ervoor dat er bij printBord een lege versie wordt uitgeprint

    private void startBord() {

        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int k = 0; k < 3; k++) {
                bord[r][k] = "___|";
            }

        }


    }


    public void printBord() {


        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int k = 0; k < 3; k++) {
                System.out.print(bord[r][k]);
            }
            System.out.println();

        }

        System.out.println("Huidig aantal zetten: " + count);

    }

//Bekijkt of drie van dezelfde in rijen en kolommen voorkomen
    private boolean checkRijenKolom(String[][] bord) {

        for (int r = 0; r < 3; r++) {
            if (bord[r][0].equals(speler) && bord[r][1].equals(speler) && bord[r][2].equals(speler)) {
                return true;
            }
            if (bord[0][r].equals(speler) && bord[1][r].equals(speler) && bord[2][r].equals(speler)) {
                return true;
            }

        }
        return false;
    }

    public boolean checkWinst(String speler) {

        if (checkRijenKolom(bord)) {
            System.out.println("Speler " + speler + "heeft gewonnen met 3 op een rij!");
            return true;
        }

        //mogelijk omhoog schuiven?

        else if ((bord[0][0].equals(speler)) && (bord[1][1].equals(speler)) && (bord[2][2].equals(speler))) {
            System.out.println("Speler " + speler + "heeft gewonnen met 3 op een rij!");
            return true;
        } else if ((bord[2][0].equals(speler)) && (bord[1][1].equals(speler)) && (bord[0][2].equals(speler))) {
            System.out.println("Speler " + speler + " heeft gewonnen met 3 op een rij!");
            return true;
        }

        return false;
    }


    // Geeft aan welke markering neergezet moet worden

    public String getSpeler() {
        return speler;
    }

    //Zorgt dat er een spelerwissel is per ronde

    public void spelerWissel() {
         if (speler == "_X_|") {
            speler = "_O_|";
        } else {
            speler = "_X_|";
        }
        count++;
        //System.out.println(count);


    }

    public boolean spelerZet(int rij, int kol) {
        if ((rij >= 0 && rij < 3) && (kol >= 0 && kol < 3)) {
            if (bord[rij][kol] == "___|") {
                bord[rij][kol] = speler;
                //spelerWissel();
                return true;
            }
            return ongeldigeZet();
        }
        return ongeldigeZet();

    }

    public static int valideerInput(String i) {
        int result;
        try {
            result = Integer.parseInt(i);
        } catch(Exception e){
            return 10;
        }
        return result;
    }

    private boolean ongeldigeZet() {
        System.out.println("Deze zet is niet valide, kies een andere zet!");
        printBord();
        return false;
    }

    public boolean spelEinde() {
        if (checkWinst(speler)) {
            return true;
        }
        return false;
    }
}





