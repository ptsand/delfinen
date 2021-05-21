package view;

import java.util.Scanner;
import controller.Controller;
import model.Medlem;

public class Start implements View {

    private Controller controller;
    private static Start instance;

    public static Start getInstance(){
        if(instance == null){
            instance = new Start();
        }
        return instance;
    }
    @Override
    public void print() {
        System.out.println("Hovedmenu:");
        System.out.println("1. Opret nyt medlem");
        System.out.println("2. Rediger eksisterende medlem");
        System.out.println("3. ....");
        System.out.println("q. Exit");
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        switch (in.next()) {
            case "1":
                System.out.println("Du har valgt at oprette et nyt medlem");
                controller.setView(OpretMedlem.getInstance());
                break;
            case "2":
                System.out.println("Går til rediger medlem");
                // controller.setView(RedigerMedlem.getInstance());
                break;
            case "q":
                System.out.println("Farvel...");
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


