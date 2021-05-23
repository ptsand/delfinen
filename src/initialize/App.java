package initialize;

import controller.Controller;
import view.StartMenu;
import view.View;

public class App {

    public static void main(String[] args) {
        View start = StartMenu.getInstance();
        Controller controller = new Controller(start);
        controller.hentTilstand();
        controller.setView(start);
    }

}
