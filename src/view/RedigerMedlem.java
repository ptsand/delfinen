package view;

import controller.Controller;
import model.Medlem;
import model.MedlemStatus;
import util.KonsolInputOutput;

import java.util.Scanner;
// @Author Simon
public class RedigerMedlem implements View {

    private Controller controller;
    private KonsolInputOutput io;
    private static view.RedigerMedlem instance;

        public static view.RedigerMedlem getInstance(){
            if(instance == null){
                instance = new view.RedigerMedlem();
            }
            return instance;
        }
        @Override
        public void print() {
            io.println("Rediger medlem");
            io.println("Vælg medlem: ");
            for (int i = 0; i < controller.getMedlem().size(); i++) {
                Medlem m = controller.getMedlem().get(i);
                io.printf("%d) Navn: %s, Email: %s, Tlf: %s Status: %s\n",
                        i, m.getNavn(), m.getEmail(), m.getTlf(), m.getStatus());
            }
        }

        @Override
        public void handleInput() {
            Scanner in = new Scanner(System.in);
            int valg = io.getNextInt();
            Medlem medlem = controller.getMedlem().get(valg);
            io.println("Rediger (vælg): ");
            io.println("0) Navn");
            io.println("1) Tlf");
            io.println("2) Email");
            io.println("3) MedlemStatus (Passiv / Aktiv)");
            io.println("4) Slet medlem");
            io.println("5) Tilbage til startmenuen");

            valg = io.getNextInt();
            switch (valg) {
                case 0:
                    io.println("Indtast nyt navn: ");
                    medlem.setNavn(io.getNextString());
                    break;
                case 1:
                    io.println("Indtast nyt tlf nummer: ");
                    medlem.setTlf(io.getNextString());
                    break;
                case 2:
                    io.println("Indtast ny email: ");
                    medlem.setEmail(io.getNextString());
                    break;
                case 3:
                    io.println("Vælg ny status: ");
                    MedlemStatus[] status = MedlemStatus.values();
                    for (int i = 0; i < status.length; i++) {
                        io.printf("%d) %s\n", i, status[i]);
                    }
                    valg = io.getNextInt();
                    medlem.setStatus(status[valg]);
                    break;
                case 4:
                    controller.sletMedlem(medlem);
                    io.println("Medlem slettet");
                    break;
                case 5:
                    io.println("Går til startmenu...");
                    break;
            }
            controller.setView(StartMenu.getInstance());
        }
        @Override
        public void setController(Controller c) {
            this.controller = c;
        }

    @Override
    public void setIO(KonsolInputOutput io) {
        this.io = io;
    }

    @Override
    public KonsolInputOutput getIO() {
        return io;
    }

    @Override
    public Controller getController() {
            return this.controller;
        }
}
