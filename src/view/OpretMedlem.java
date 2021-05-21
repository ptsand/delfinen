package view;

import java.util.Collections;
import java.util.Scanner;
import controller.Controller;
import model.Medlem;

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
        controller.tilføjMedlem(new Medlem(navn, telefon, email));
        System.out.printf("%s er nu oprettet som medlem", navn);
        controller.setView(Start.getInstance());
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

