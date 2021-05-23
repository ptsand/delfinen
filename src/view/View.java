package view;

import controller.Controller;
// @Author Peter Sand
public interface View {
    void print();
    void handleInput();
    void setController(Controller c);
    Controller getController();
}
