package com.pluralsight.bokaei;

/*1. Start Bord
2, - Spelerzet
   - is het n valide zet?
   - plaats spelericoon op het bord
   - bekijk of het spel over is (rij/kolom/diagonalen (probably met n boelejan en dan daarmee zorgen dattie n printje doet
   - wissel van speler
   - volgende zet
   - bekijk status
   - zorgen dat ik n count heb die tot 9 gaat, na 9 stopt het spel sowiso met n draw als aan voorafgaande voorwaarden niet voldaan is

3. Speleinde (X win/ O wint / gelijkspel)
*/


import java.util.Scanner;

public class BkeTwo {

    //Classvariabelen neerzetten, private

    //public static int rij, kol;
    public static Scanner sc = new Scanner(System.in);
    private String[][] bord;
    private String speler;
    private int count = 0;

    public BkeTwo() {
        bord = new String[3][3];
        speler = "_X_|";
        // kijken of ik mn spelicoontjes wat smoother kan maken, dit ziet er kut uit.
        //startBord(); **Niet nodig denk ik, kan m vanuit main aanslingeren, not sure of ik m beter in mn constructor kan plaatsen**
        // probably beter vanuit hier om tijdens creabea van mn object gewoon mn startbord neer te knallen


    }


    public static void main(String[] args) {


    }
    //Zorgt icm printBord voor de configuratie van het bord
    // Hier moet ik probably wat aan schaven om die spelicoontjes soepel te krijgen

    public void startBord() {

        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int k = 0; k < 3; k++) {
                System.out.print(bord[r][k] = "___| ");
                //bord[r][k] = "___|";
            }
            System.out.println();

        }


    }


    public void printBord() {


        for (int r = 0; r < 3; r++) {
            System.out.print("|");
            for (int k = 0; k < 3; k++) {
                System.out.print(bord[r][k] = "___|");
            }
            System.out.println();

        }
    }

 // Bekijkt rijen, kolommen, diagonalen voor een winst

    public boolean spelEinde(int rMove, int kMove) {

        //ff n rijencheck en kolomcheck neerpleuron, should be fine. Stringvergelijken etc.

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
    }

    public boolean spelerZet(int rij, int kol) {
        if ((rij >= 0) && (kol < 3)) {
            if (bord[rij][kol] == "___|") {
                bord[rij][kol] = speler;
                return true;
                }
        }
        return false;
    }

    public String zetControle(int spelerZet){

        /////Zoiets
        return "Jalekkermeijer";
    }

    public boolean testJoekoe(){
        if (speler == "XXX"){
            return true;
        }
        return false;
    }
}





