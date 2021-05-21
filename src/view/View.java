package view;

import controller.Controller;

public interface View {
    void print();
    void handleInput();
    void setController(Controller c);
    Controller getController();
}
