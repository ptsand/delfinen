package view;

import controller.Controller;
import model.Disciplin;
import model.KonkurrenceSvømmer;
import model.Medlem;
import util.KonsolInputOutput;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TilføjTræningsResultat implements View {

    private Controller controller;
    private KonsolInputOutput io;
    private List<Medlem> svømmer;
    private static TilføjTræningsResultat instance;

    public static TilføjTræningsResultat getInstance(){
        if(instance == null){
            instance = new TilføjTræningsResultat();
        }
        return instance;
    }

    @Override
    public void print() {
        io.println("Tilføj træningsresultat");
        io.println("Vælg en af konkurrence svømmerne: ");
        svømmer = controller.getMedlem().stream()
                .filter(p -> p instanceof KonkurrenceSvømmer).collect(Collectors.toList());
        for (int i = 0; i < svømmer.size(); i++) {
            Medlem medlem = svømmer.get(i);
            io.printf("%d) Navn: %s, Email: %s, Tlf: %s\n", i, medlem.getNavn(), medlem.getEmail(), medlem.getTlf());
        }
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        int index = io.getNextInt();
        Medlem svømmer = this.svømmer.get(index);
        io.println("Vælg disciplin: ");
        Disciplin[] disciplin = Disciplin.values();
        for (int i = 0; i < disciplin.length; i++) {
            io.printf("%d) %s\n", i, disciplin[i]);
        }
        index = io.getNextInt();
        io.println("Indtast tid i ms: ");
        int tidMS = io.getNextInt();
        controller.tilføjTræningsResultat((KonkurrenceSvømmer) svømmer, disciplin[index], tidMS);
        controller.setView(StartMenu.getInstance());
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
        return controller;
    }
}
