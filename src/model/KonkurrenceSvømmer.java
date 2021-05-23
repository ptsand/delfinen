package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;

public class KonkurrenceSvømmer extends Medlem {

    private Træner træner;
    private ArrayList<Stævne> stævne;
    // Mapping fra disciplin til bedste træningsresultat i ms
    private EnumMap<Disciplin, Integer> disciplinResultat = new
                EnumMap<Disciplin, Integer>(Disciplin.class);

    public KonkurrenceSvømmer(String navn, String tlf, String email, LocalDate fødselsdato, MedlemStatus status) {
        super(navn, tlf, email, fødselsdato, status);
    }

    public EnumMap<Disciplin, Integer> getDisciplinResultat() {
        return disciplinResultat;
    }
}
