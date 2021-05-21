package model;

import java.io.Serializable;

public class Medlem implements Serializable {

    private String navn, tlf, email, fødselsdato;
    private Betaling betaling;
    private boolean erAktiv;

    public Medlem(String navn, String tlf, String email, String fødselsdato) {
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getTlf() {
        return tlf;
    }

    public String getEmail() {
        return email;
    }

    public boolean erAktiv() {
        return erAktiv;
    }
}
