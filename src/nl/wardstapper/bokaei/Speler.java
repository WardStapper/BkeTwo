package nl.wardstapper.bokaei;

public class Speler {
    private String symbool;
    private String naam;


    public Speler(String symbool, String naam) {
        this.symbool = symbool;
        this.naam = naam;
    }

    public String getSymbool() {
        return symbool;
    }

    public String getNaam() {
        return naam;
    }
}

