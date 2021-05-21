package view;

import controller.Controller;
import model.Medlem;

import java.util.Scanner;

public class RedigerMedlem implements View {

        private Controller controller;
        private static view.RedigerMedlem instance;

        public static view.RedigerMedlem getInstance(){
            if(instance == null){
                instance = new view.RedigerMedlem();
            }
            return instance;
        }
        @Override
        public void print() {
            System.out.println("Vælg medlem: ");
            for (Medlem medlem : controller.getMedlemmer()) {
                System.out.printf("%s %s %s\n", medlem.getNavn(), medlem.getEmail(), medlem.getTlf());
            }
        }

        @Override
        public void handleInput() {
            Scanner in = new Scanner(System.in);
            // TODO: gør det muligt at redigere det valgte medlem
            controller.setView(Start.getInstance());
        }

        @Override
        public void setController(Controller c) {
            this.controller = c;
        }

        @Override
        public Controller getController() {
            return this.controller;
        }
}
