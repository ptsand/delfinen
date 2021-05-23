package view;

import controller.Controller;
import model.Medlem;
import model.MedlemStatus;

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
            System.out.println("Rediger medlem");
            System.out.println("Vælg medlem: ");
            for (int i = 0; i < controller.getMedlem().size(); i++) {
                Medlem m = controller.getMedlem().get(i);
                System.out.printf("%d) Navn: %s, Email: %s, Tlf: %s Status: %s\n",
                        i, m.getNavn(), m.getEmail(), m.getTlf(), m.getStatus());
            }
        }

        @Override
        public void handleInput() {
            Scanner in = new Scanner(System.in);
            int valg = in.nextInt();
            Medlem medlem = controller.getMedlem().get(valg);
            System.out.println("Rediger (vælg): ");
            System.out.println("0) Navn");
            System.out.println("1) Tlf");
            System.out.println("2) Email");
            System.out.println("3) MedlemStatus (Passiv / Aktiv)");
            System.out.println("4) Slet medlem");
            System.out.println("5) Tilbage til startmenuen");

            valg = in.nextInt();
            switch (valg) {
                case 0:
                    System.out.println("Indtast nyt navn: ");
                    medlem.setNavn(in.next());
                    break;
                case 1:
                    System.out.println("Indtast nyt tlf nummer: ");
                    medlem.setTlf(in.next());
                    break;
                case 2:
                    System.out.println("Indtast ny email: ");
                    medlem.setEmail(in.next());
                    break;
                case 3:
                    System.out.println("Vælg ny status: ");
                    MedlemStatus[] status = MedlemStatus.values();
                    for (int i = 0; i < status.length; i++) {
                        System.out.printf("%d) %s\n", i, status[i]);
                    }
                    valg = in.nextInt();
                    medlem.setStatus(status[valg]);
                    break;
                case 4:
                    controller.sletMedlem(medlem);
                    System.out.println("Medlem slettet");
                    break;
                case 5:
                    System.out.println("Går til startmenu...");
                    break;
            }
            controller.setView(StartMenu.getInstance());
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
