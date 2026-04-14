package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class Symptom {
    public static final Codec<RegistryEntry<Symptom>> CODEC = PPRegistries.SYMPTOM
            .getEntryCodec()
            .validate(entry -> entry.matches(Objects::isNull) || entry.matches(PPSymptoms.EMPTY) ? DataResult.error(() -> "Symptom cannot be null") : DataResult.success(entry));

    private final RegistryWrapper.WrapperLookup registries = BuiltinRegistries.createWrapperLookup();
    private final RegistryEntry.Reference<Symptom> registryEntry = this.registries.getWrapperOrThrow(PPRegistries.symptomKey).getOrThrow(RegistryKey.of(PPRegistries.symptomKey, getId(this)));

    private final String name;

    public Symptom(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return this == PPSymptoms.EMPTY;
    }

    public boolean isIn(TagKey<Symptom> tag) {
        return this.registryEntry.isIn(tag);
    }

    public String getName() {
        return this.name;
    }

    public static Identifier getId(Symptom symptom) {
        return PPRegistries.SYMPTOM.getId(symptom);
    }

    public void getTickingEffect(LivingEntity living) {}
    public void getHitEffect(LivingEntity living, LivingEntity target) {}
}
