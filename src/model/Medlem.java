package model;

public class Medlem {

    private String navn, tlf, email;
    private Betaling betaling;

    public Medlem(String navn, String tlf, String email) {
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
    }

}
