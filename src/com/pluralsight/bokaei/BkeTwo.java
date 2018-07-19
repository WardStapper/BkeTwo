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

    //Constructor zorgt voor eerste opzet van het bord
    public BkeTwo() {
        bord = new String[3][3];
        speler = "_X_|";
        startBord();
    }


    public static void main(String[] args) {


    }
    //Zorgt icm printBord voor de configuratie van het bord
    // Hier moet ik probably wat aan schaven om die spelicoontjes soepel te krijgen

    public void startBord() {

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
        count++;
    }

 // Bekijkt rijen, kolommen, diagonalen voor een winst

    public boolean spelWinst(   ) {
        // per rij bekijken?


        for ( int r = 0; r < 3 ; r++ ){
            if (count < 9){
                if (bord[r][0] && bord[r][1] && bord[r][2]!= "__|"  )

        //per kolom bekijken?
         for (int k = 0; k < 3; k++){
              if (count < 9){
                  if (bord[0][k] && bord [1][k] & bord [2][k] != "___|"}

              }


         }
            }
            else
                System.out.println("Helaas, het is een gelijkspel geworden!");

        }

    {
        return (((bord[0][0], bord[1][1], bord[2][2]) == true) || ((bord[0][2], bord[1][1], bord[2][0]) == true));
    }
        //kan ik hier vandaan misschien n string in de 'zelfdeSpeler' boolean gooien?

        //if (rReeks == true)

        //ff n rijencheck en kolomcheck neerpleuron, should be fine. Stringvergelijken etc.

        return false;


    }
    //bedenken hoe ik die strings erin krijg, kijken of ik die return false terug kan brengen naar 1 zonder dat mn compiler gaat langemeijeren
    public boolean zelfdeSpeler(String s1, String s2, String s3){

        if (s1 != "_X_|"){
            if (s1 != "_O_|"){
                return ((s1 == s2)&&(s2 == s3));
            }
        }

        else {
            return false;
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





