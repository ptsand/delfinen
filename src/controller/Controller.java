package controller;

import model.Disciplin;
import model.KonkurrenceSvømmer;
import model.Medlem;
import model.MedlemStatus;
import util.KonsolInputOutput;
import view.StartMenu;
import view.View;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Medlem> medlem = new ArrayList<Medlem>();
    private KonsolInputOutput io;
    private View view;

    public ArrayList<Medlem> getMedlem() {
        return medlem;
    }

    public Controller(KonsolInputOutput io) {
        this.io = io;

    }

    public void setView(View view) {
        this.view = view;
        if (view.getController() == null) view.setController(this);
        if (view.getIO() == null) view.setIO(io);
        view.print();
        view.handleInput();
    }
    public void opstart(){
        hentTilstand();
        setView(StartMenu.getInstance());
    }
    public void tilføjMedlem(Medlem medlem) {
        this.medlem.add(medlem);
    }

    public void sletMedlem(Medlem medlem) {
        this.medlem.remove(medlem);
    }

    public void tilføjTræningsResultat(KonkurrenceSvømmer svømmer, Disciplin disciplin, int tidMS) {
        svømmer.getDisciplinResultat().put(disciplin, tidMS);
    }

    private void indlæsTestData() {
        tilføjMedlem(new Medlem("testnavn1","88888888","tet@mail.dk", LocalDate.parse("1986-12-30"), MedlemStatus.AKTIV));
        for (int i = 0; i < 5; i++) {
            KonkurrenceSvømmer s = new KonkurrenceSvømmer(
                    "tnavn"+i,"88888889","tet2@mail.dk",LocalDate.parse("1986-12-10"), MedlemStatus.AKTIV);
            s.getDisciplinResultat().put(Disciplin.RYGCRAWL, 1000-i);
            tilføjMedlem(s);
        }
    }
    // Hent Serialiseret data (Listen medlem) fra filen medlemmer.ser
    public void hentTilstand() {
        try {
            FileInputStream fileIn = new FileInputStream("medlemmer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.medlem = (ArrayList<Medlem>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            // Hvis filen ikke kan åbnes load test data i stedet
            indlæsTestData();
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
    }
    // Gem Serialiseret data (Listen medlem) i filen medlemmer.ser
    public void gemTilstand() {
        try {
            FileOutputStream fileOut = new FileOutputStream("medlemmer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(medlem);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
