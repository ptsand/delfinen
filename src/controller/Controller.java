package controller;

import model.Medlem;
import view.View;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Medlem> medlemmer = new ArrayList<Medlem>();
    private View view;

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public Controller(View view) {
        this.view = view;
    }

    public void setView(View view) {
        this.view = view;
        if (view.getController() == null) view.setController(this);
        view.print();
        view.handleInput();
    }

    public void tilføjMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public void hentTilstand() {
        // TODO: Tilføj medlemmer fra csv til "medlemmer" arraylisten

        try {
            FileInputStream fileIn = new FileInputStream("medlemmer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.medlemmer = (ArrayList<Medlem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) { // hvis filen ikke eksisterer
            //i.printStackTrace();
            //return;
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
    }

    public void gemTilstand() {
        // TODO: Gem medlemmer til csv fra "medlemmer" arraylisten
        try {
            FileOutputStream fileOut = new FileOutputStream("medlemmer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(medlemmer);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data gemt i medlemmer.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
