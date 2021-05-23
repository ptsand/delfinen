package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Medlem implements Serializable {

    private String navn, tlf, email;
    private LocalDate fødselsdato;
    private MedlemStatus status;

    public Medlem(String navn, String tlf, String email, LocalDate fødselsdato, MedlemStatus status) {
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
        this.fødselsdato = fødselsdato;
        this.status = status;
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

    public LocalDate getFødselsdato() {
        return fødselsdato;
    }

    public MedlemStatus getStatus() {
        return status;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(MedlemStatus status) {
        this.status = status;
    }
}
