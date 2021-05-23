package view;

import java.util.Scanner;
import java.time.LocalDate;
import controller.Controller;
import model.KonkurrenceSvømmer;
import model.Medlem;
import model.MedlemStatus;

public class OpretMedlem implements View {

    private Controller controller;
    private static OpretMedlem instance;

    public static OpretMedlem getInstance(){
        if(instance == null){
            instance = new OpretMedlem();
        }
        return instance;
    }
    @Override
    public void print() {
        System.out.println("Opret nyt medlem");
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Navn: ");
        String navn = in.next();
        System.out.println("Telefon: ");
        String telefon = in.next();
        System.out.println("Email: ");
        String email = in.next();
        System.out.println("Fødselsdato (Year-Month-Day): ");
        LocalDate fødselsdato = LocalDate.parse(in.next());
        System.out.println("Vælg status: ");
        MedlemStatus[] status = MedlemStatus.values();
        for (int i = 0; i < status.length; i++) {
            System.out.printf("%d) %s\n", i, status[i]);
        }
        int valg = in.nextInt();
        MedlemStatus valgtStatus = status[valg];
        System.out.println("Konkurrence svømmer (ja/nej, default=nej): ");
        String konkurrenceSvømmer = in.next();
        if (konkurrenceSvømmer.equalsIgnoreCase("ja")) {
            controller.tilføjMedlem(new KonkurrenceSvømmer(navn, telefon, email, fødselsdato, valgtStatus));
        } else {
            controller.tilføjMedlem(new Medlem(navn, telefon, email, fødselsdato, valgtStatus));
        }
        System.out.printf("%s er nu oprettet som medlem\n", navn);
        controller.setView(StartMenu.getInstance());
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    @Override
    public Controller getController() {
        return this.controller;
    }
}

