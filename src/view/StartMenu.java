package view;

import controller.Controller;
import util.KonsolInputOutput;
//@Author Simon
public class StartMenu implements View {

    private Controller controller;
    private KonsolInputOutput io;
    private static StartMenu instance;

    public static StartMenu getInstance(){
        if(instance == null){
            instance = new StartMenu();
        }
        return instance;
    }
    @Override
    public void print() {
        io.println("Hovedmenu:");
        io.println("1. Opret nyt medlem");
        io.println("2. Rediger eksisterende medlem");
        io.println("3. Tilføj træningsresultat");
        io.println("4. Se Top5");
        io.println("q. Luk og gem");
        io.println("x. Luk uden at gemme");
    }

    @Override
    public void handleInput() {
        switch (io.getNextString()) {
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
                io.println("Gemmer og lukker");
                controller.gemTilstand();
                System.exit(0);
            case "x":
                io.println("Lukker uden at gemme");
                System.exit(0);
        }
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    @Override
    public void setIO(KonsolInputOutput io) {
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


