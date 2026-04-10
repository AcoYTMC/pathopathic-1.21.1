package net.chemthunder.pathopathic.impl.util;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public interface PPRegistryKeys {
    RegistryKey<Registry<Symptom>> SYMPTOM = RegistryKey.ofRegistry(Pathopathic.id("symptom"));
    RegistryKey<Registry<Disease>> DISEASE = RegistryKey.ofRegistry(Pathopathic.id("disease"));
}
