package model;

import java.time.LocalDate;
import java.util.EnumMap;
//@Author Nicolas
public class KonkurrenceSvømmer extends Medlem {

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
