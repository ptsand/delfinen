package controller;

import model.Medlem;
import view.View;
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
    }

    public void gemTilstand() {
        // TODO: Gem medlemmer til csv fra "medlemmer" arraylisten.
    }
}
