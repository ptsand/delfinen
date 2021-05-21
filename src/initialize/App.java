package initialize;

import controller.Controller;
import view.Start;
import view.View;

public class App {

    public static void main(String[] args) {
        View start = Start.getInstance();
        Controller controller = new Controller(start);
        controller.setView(start);
    }

}
