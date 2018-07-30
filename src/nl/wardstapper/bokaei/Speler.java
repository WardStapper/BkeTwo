package nl.wardstapper.bokaei;

public class Speler {
    private String symbool;
    private String naam;

    //constructor die een naam en symbooltje geeft aan de spelers
    public Speler(String symbool, String naam) {
        this.symbool = symbool;
        this.naam = naam;
    }
    //zorgt ervoor dat er een symbooltje gezet wordt ipv een spelernaam in mijn BkeTwo class.
    public String getSymbool() {
        return symbool;
    }
    //zorgt ervoor dat er een naam gegeven wordt ipv een symbooltje in mijn BkeTwo class.
    public String getNaam() {
        return naam;
    }
}

