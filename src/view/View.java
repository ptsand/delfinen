package view;

import controller.Controller;
import util.KonsolInputOutput;

// @Author Peter
public interface View {
    void print();
    void handleInput();
    void setController(Controller c);
    void setIO(KonsolInputOutput io);
    KonsolInputOutput getIO();
    Controller getController();
}
