package com.pluralsight.bokaei;

import java.util.Scanner;

public class BkeTwo {

    //Classvariabelen neerzetten, private
    //count neerzetten om ervoor te zorgen dat het spel na 9 zetten niet kan doorgaan. (gelijkspel e.d.)
    //mogelijk met spelerzet == true -> spelerwissel

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
             for (int k = 0; k < 3; k++) {
                bord[r][k] = "___|";
            }
                    }
        spelWelkom();

    }
    //verwelkomt de speler
    public void spelWelkom(){

        System.out.println("Welkom spelers, voer nu ieder je naam in om te beginnen met spelen!");
        System.out.println("Speler een, wat is je naam?: ");
        String spelereen = sc.nextLine();
        System.out.println("Welkom, " + spelereen + ", jij speelt nu icoontje X!" );
        System.out.println("Speler twee, wat is je naam?:");
        String spelertwee = sc.nextLine();
        System.out.println("Welkom " + spelertwee + ", jij speelt nu icoontje O!");
        System.out.println();


        //Ik kan mogelijk de spelernaam in een string gooien, dan ervoor zorgen dat ik die steeds call met de spelerwissel -> getspeler?
        //String spelernaam;


        //System.out.println(spelereen + " begint met X! Kies een positie die je wilt invullen. Eerste de rij, dan de kolom");

    }
    //print de nieuwe bord met zet

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

    public String getSpeler() {return speler;}

    //implementatie van gelijkspel
    public int getCount() {return count;}

    //Zorgt dat er een spelerwissel is per ronde

    public void spelerWissel() {
        if (speler == "_X_|") {
            speler = "_O_|";
        } else {
            speler = "_X_|";
        }

        count++;



    }
    //plaats het spelericoontje op het bord mits deze "___|" is.
    public boolean spelerZet(int rij, int kol) {
        if ((rij >= 0 && rij < 3) && (kol >= 0 && kol < 3)) {
            if (bord[rij][kol] == "___|") {
                bord[rij][kol] = speler;

                return true;
            }
            System.out.println("Deze zet is niet valide, kies een andere zet!");
            return false;
        }
        System.out.println("Deze zet is niet valide, kies een andere zet! TEST");
        return false;
    }

    //Opvangen van de error die je krijgt als je bijvoorbeeld 2x e invoert bij het invoeren van de rij en kolom. -> zal het gedrag van invalide zet forceren doordat er 10 returned.

    public static int valideerInput(String i) {
        int result;
        try {
            result = Integer.parseInt(i);
        } catch(Exception e){
            return 10;
        }
        return result;
    }

    public boolean opgeven(){
        System.out.println("Wil je opgeven? Ja / Nee ?");
        String stopspel = sc.nextLine();
        stopspel.toUpperCase();
        if (stopspel == ("JA")){
            return true;
        }
        return false;


    }
   /*
    public static String valideerOpgeven(int i){
        String invoer;
        try {
            invoer =
        }
    }*/
/*
    public boolean ongeldigeZet() {
        System.out.println("Deze zet is niet valide, kies een andere zet!");
        return false;
    }

    */

    //checkt of er gewonnen is. Als dit het geval is zal dit als waarde true geven, hetgeen gewonnen op true zet. Hierdoor stopt de while loop, waardoor het spel ten einde loopt.
    public boolean spelEinde() {
        if (checkWinst(speler)) {
            return true;
        }
        return false;
    }
}





