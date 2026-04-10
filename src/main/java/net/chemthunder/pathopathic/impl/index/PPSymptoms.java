package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.symptom.CancerousSymptom;
import net.chemthunder.pathopathic.impl.symptom.InsomniaSymptom;
import net.chemthunder.pathopathic.impl.symptom.LethargicSymptom;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;

import java.util.ArrayList;
import java.util.List;

public interface PPSymptoms {
    List<Symptom> SYMPTOMS = new ArrayList<>();

    Symptom INSOMNIA = new InsomniaSymptom("insomnia");
    Symptom CANCEROUS = new CancerousSymptom("cancerous");
    Symptom LETHARGIC = new LethargicSymptom("lethargic");

    static void init() {
        SYMPTOMS.add(INSOMNIA);
        SYMPTOMS.add(CANCEROUS);
        SYMPTOMS.add(LETHARGIC);
    }
}
