package view;

import java.time.LocalDate;
import controller.Controller;
import model.KonkurrenceSvømmer;
import model.Medlem;
import model.MedlemStatus;
import util.KonsolInputOutput;

//@Author Nicolas
public class OpretMedlem implements View {

    private Controller controller;
    private KonsolInputOutput io;
    private static OpretMedlem instance;

    public static OpretMedlem getInstance(){
        if(instance == null){
            instance = new OpretMedlem();
        }
        return instance;
    }
    @Override
    public void print() {
        io.println("Opret nyt medlem");
    }

    @Override
    public void handleInput() {
        io.println("Navn: ");
        String navn = io.getNextString();
        io.println("Telefon: ");
        String telefon = io.getNextString();
        io.println("Email: ");
        String email = io.getNextString();
        io.println("Fødselsdato (YYYY-MM-DD): ");
        LocalDate fødselsdato = LocalDate.parse(io.getNextString());
        io.println("Vælg status: ");
        MedlemStatus[] status = MedlemStatus.values();
        for (int i = 0; i < status.length; i++) {
            io.printf("%d) %s\n", i, status[i]);
        }
        int valg = io.getNextInt();
        MedlemStatus valgtStatus = status[valg];
        io.println("Konkurrence svømmer (ja/nej, default=nej): ");
        String konkurrenceSvømmer = io.getNextString();
        if (konkurrenceSvømmer.equalsIgnoreCase("ja")) {
            controller.tilføjMedlem(new KonkurrenceSvømmer(navn, telefon, email, fødselsdato, valgtStatus));
        } else {
            controller.tilføjMedlem(new Medlem(navn, telefon, email, fødselsdato, valgtStatus));
        }
        io.printf("%s er nu oprettet som medlem\n", navn);
        controller.setView(StartMenu.getInstance());
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    public void setIO (KonsolInputOutput io) {
        this.io = io;
    }

    @Override
    public KonsolInputOutput getIO() {
        return io;
    }

    @Override
    public Controller getController() {
        return this.controller;
    }
}

