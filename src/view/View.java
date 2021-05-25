package view;

import controller.Controller;
import util.KonsolInputOutput;

// @Author Peter Sand
public interface View {
    void print();
    void handleInput();
    void setController(Controller c);
    void setIO(KonsolInputOutput io);
    KonsolInputOutput getIO();
    Controller getController();
}
