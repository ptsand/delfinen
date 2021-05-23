package view;

import java.util.Scanner;
import controller.Controller;

public class StartMenu implements View {

    private Controller controller;
    private static StartMenu instance;

    public static StartMenu getInstance(){
        if(instance == null){
            instance = new StartMenu();
        }
        return instance;
    }
    @Override
    public void print() {
        System.out.println("Hovedmenu:");
        System.out.println("1. Opret nyt medlem");
        System.out.println("2. Rediger eksisterende medlem");
        System.out.println("3. Tilføj træningsresultat");
        System.out.println("4. Se Top5");
        System.out.println("q. Luk og gem");
        System.out.println("x. Luk uden at gemme");
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        switch (in.next()) {
            case "1":
                controller.setView(OpretMedlem.getInstance());
                break;
            case "2":
                controller.setView(RedigerMedlem.getInstance());
                break;
            case "3":
                controller.setView(TilføjTræningsResultat.getInstance());
                break;
            case "4":
                controller.setView(SeTop5.getInstance());
                break;
            case "q":
                System.out.println("Gemmer og lukker");
                controller.gemTilstand();
                System.exit(0);
            case "x":
                System.out.println("Lukker uden at gemme");
                System.exit(0);
        }
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


