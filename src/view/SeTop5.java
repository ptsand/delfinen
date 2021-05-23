package view;

import controller.Controller;
import model.Disciplin;
import model.KonkurrenceSvømmer;
import model.Medlem;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

// @Author Peter Sand
public class SeTop5 implements View {

    private Controller controller;
    private static SeTop5 instance;

    public static SeTop5 getInstance(){
        if(instance == null){
            instance = new SeTop5();
        }
        return instance;
    }

    @Override
    public void print() {
        System.out.println("Se top5");
    }

    @Override
    public void handleInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Vælg junior (j) / senior (s) (default: j):");
        String juniorSenior = in.next();
        System.out.println("Vælg disciplin: ");
        Disciplin[] disciplin = Disciplin.values();
        for (int i = 0; i < disciplin.length; i++) {
            System.out.printf("%d) %s\n", i, disciplin[i]);
        }
        int index = in.nextInt();
        Disciplin valgtDisciplin = disciplin[index];
        List<Medlem> svømmer = getSvømmer(valgtDisciplin, juniorSenior);
        // sorter resultater for seniore - eller juniore efter bedste tid inden for den valgte disciplin
        Collections.sort(svømmer, getComparator(valgtDisciplin));
        System.out.println("top 5 indenfor " + disciplin[index]);

        for (int i = 0; i < svømmer.size() && i <= 4; i++) {
            Medlem s = svømmer.get(i);
            System.out.printf("%d) %s : %d ms\n", i+1, s.getNavn(),
                    ((KonkurrenceSvømmer) s).getDisciplinResultat().get(disciplin[index]));
        }
        controller.setView(StartMenu.getInstance());
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    @Override
    public Controller getController() {
        return controller;
    }
    // Filtrer almindelige medlemmer fra, da de ikke har nogen resultater
    private Stream<Medlem> getSvømmer(Disciplin disciplin) {
        return controller.getMedlem().stream()
                .filter(p -> p instanceof KonkurrenceSvømmer)
                .filter(p -> ((KonkurrenceSvømmer) p).getDisciplinResultat().containsKey(disciplin));
    }
    // Returner kun Seniorerne eller Juniorerne indenfor en disciplin
    private List<Medlem> getSvømmer(Disciplin disciplin, String juniorSenior) {
        if (juniorSenior.equalsIgnoreCase("s")) {
            System.out.print("Senior ");
            return getSvømmer(disciplin)
                    .filter(p -> ChronoUnit.YEARS.between(p.getFødselsdato(), LocalDate.now()) >= 18)
                    .collect(Collectors.toList());
        } else {
            System.out.print("Junior ");
            return getSvømmer(disciplin)
                    .filter(p -> ChronoUnit.YEARS.between(p.getFødselsdato(), LocalDate.now()) < 18)
                    .collect(Collectors.toList());
        }
    }
    // Returner Comparator til at sortere efter bedste tid inden for den valgte disciplin
    private Comparator<Medlem> getComparator(Disciplin d) {
        return Comparator.comparingInt(p -> ((KonkurrenceSvømmer) p).getDisciplinResultat().get(d));
    }
}
