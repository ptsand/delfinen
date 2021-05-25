package initialize;

import controller.Controller;
import util.KonsolInputOutput;

public class App {

    public static void main(String[] args) {
        KonsolInputOutput io = new KonsolInputOutput();
        Controller controller = new Controller(io);
    }

}
