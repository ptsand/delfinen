package view;

import controller.Controller;
import model.Disciplin;
import model.KonkurrenceSvømmer;
import model.Medlem;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TilføjTræningsResultat implements View {

    private Controller controller;
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
        System.out.println("Tilføj træningsresultat");
        System.out.println("Vælg en af konkurrence svømmerne: ");
        svømmer = controller.getMedlem().stream()
                .filter(p -> p instanceof KonkurrenceSvømmer).collect(Collectors.toList());
        for (int i = 0; i < svømmer.size(); i++) {
            Medlem medlem = svømmer.get(i);
            System.out.printf("%d) Navn: %s, Email: %s, Tlf: %s\n", i, medlem.getNavn(), medlem.getEmail(), medlem.getTlf());
        }
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        Medlem svømmer = this.svømmer.get(index);
        System.out.println("Vælg disciplin: ");
        Disciplin[] disciplin = Disciplin.values();
        for (int i = 0; i < disciplin.length; i++) {
            System.out.printf("%d) %s\n", i, disciplin[i]);
        }
        index = in.nextInt();
        System.out.println("Indtast tid i ms: ");
        int tidMS = in.nextInt();
        controller.tilføjTræningsResultat((KonkurrenceSvømmer) svømmer, disciplin[index], tidMS);
        controller.setView(StartMenu.getInstance());
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    @Override
    public Controller getController() {
        return controller;
    }
}
