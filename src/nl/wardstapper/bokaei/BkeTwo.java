package nl.wardstapper.bokaei;

import java.util.Scanner;

public class BkeTwo {

    //Classvariabelen neerzetten, private

    private static Scanner sc = new Scanner(System.in);
    private String[][] bord;
    private Speler speler;
    private int count = 0;
    private Speler speler1;
    private Speler speler2;

    //Constructor zorgt voor eerste opzet van het bord

    public BkeTwo() {
        bord = new String[3][3];
        startBord();
    }

    //Zorgt voor de eerste weergave van het bord
    //Verwelkomt de speler
    //Zorgt ervoor dat er bij printBord een lege versie wordt uitgeprint

    private void startBord() {

        for (int r = 0; r < 3; r++) {
            for (int k = 0; k < 3; k++) {
                bord[r][k] = "___|";
            }
        }
        spelWelkom();
        printBord();

    }

    //Verwelkomt de speler
    //Geeft aan dat er een optie is om vroegtijdig te stoppen
    private void spelWelkom() {

        System.out.println("Welkom spelers, voer nu ieder je naam in om te beginnen met spelen!");
        System.out.println("Speler een, wat is je naam?: ");
        String spelereen = sc.nextLine();
        this.speler1 = new Speler("_X_|" , spelereen);
        System.out.println("Welkom, " + spelereen + ", jij speelt nu icoontje X!");
        System.out.println("Speler twee, wat is je naam?:");
        String spelertwee = sc.nextLine();
        this.speler2 = new Speler("_O_|" , spelertwee);
        System.out.println("Welkom " + spelertwee + ", jij speelt nu icoontje O!");
        System.out.println();
        System.out.println("Om het spel vroegtijdig te stoppen, type stop in tijdens je beurt!");
        System.out.println(spelereen + " begint met X! Kies een positie die je wilt invullen. Eerste de rij, dan de kolom");
        speler = speler1;

    }
    //Nieuwe bordpritn met de nieuwe zet erop.

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
            if (bord[r][0].equals(speler.getSymbool()) && bord[r][1].equals(speler.getSymbool()) && bord[r][2].equals(speler.getSymbool())) {
                return true;
            }
            if (bord[0][r].equals(speler.getSymbool()) && bord[1][r].equals(speler.getSymbool()) && bord[2][r].equals(speler.getSymbool())) {
                return true;
            }

        }
        return false;
    }

    //Bekijkt winst bij rijen en kolommen via checkRijenKolom
    //Bekijkt winst bij diagonalen
    //Geeft een true door als er sprake is van winst. Hetgeen ervoor zorgt dat in main checkWinst true geeft, wat gelijk is aan gewonnen. Hierdoor stopt de while loop en is het spel klaar.

    public boolean checkWinst() {


        if (checkRijenKolom(bord)) {
            System.out.println("Speler " + speler.getNaam() + "heeft gewonnen met 3 op een rij!");
            return true;
        } else if ((bord[0][0].equals(speler.getSymbool())) && (bord[1][1].equals(speler.getSymbool())) && (bord[2][2].equals(speler.getSymbool()))) {
            System.out.println("Speler " + speler.getNaam() + "heeft gewonnen met 3 op een rij!");
            return true;
        } else if ((bord[2][0].equals(speler.getSymbool())) && (bord[1][1].equals(speler.getSymbool())) && (bord[0][2].equals(speler.getSymbool()))) {
            System.out.println("Speler " + speler.getNaam() + " heeft gewonnen met 3 op een rij!");
            return true;
        }


        return false;
    }


    //Geeft spelernaam aan het mainframe door

    public Speler getSpeler() {
        return speler;
    }

    //Zorgt dat er een spelerwissel is per ronde
    //Zorgt voor een count per spelerwissel.

    public void spelerWissel() {
        speler =  speler.equals(speler1) ? speler2 : speler1;

        count++;


    }

    //Plaatst het spelericoontje op het bord mits deze "___|" is.
    public boolean spelerZet(int rij, int kol) {
        if ((rij >= 0 && rij < 3) && (kol >= 0 && kol < 3)) {
            if (bord[rij][kol] == "___|") {
                bord[rij][kol] = speler.getSymbool();

                return true;
            }
            System.out.println("Deze zet is niet valide, kies een andere zet!");
            return false;
        }
        System.out.println("Deze zet is niet valide, kies een andere zet!");
        return false;
    }

    //Faciliteren van het stoppen van het stop dmv 'stop'
    //Opvangen van de error die je krijgt als je bijvoorbeeld 2x e invoert bij het invoeren van de rij en kolom. Gedrag van een verkeerde zet forceren doordat er 10 returned.

    public int valideerInput(String i)  {
        String spelstop = i.toLowerCase();
        if (spelstop.equals( "stop")){
            System.out.println("Het spel is afgelopen, speler "  + speler.getNaam() + " heeft opgegeven binnen " + count + " zetten!" );
            System.exit(0);
        }

        int result;
        try {
            result = Integer.parseInt(i);
        } catch(Exception e){
            return 10;
        }
        return result;
    }
    //vroegtijdig stoppen van het spel, verder kijken of deze op een elegantere manier een implementatie kan krijgen.


    public boolean checkGelijkspel() {
        if (count == 9) {
            System.out.println("Helaas, " + speler1.getNaam() +  " en " + speler2.getNaam() +  " , het is een gelijkspel geworden!");
            return true;
        }
        return false;
    }
}




