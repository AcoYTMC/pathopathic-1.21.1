package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.LivingEntity;

public class Symptom {
    public final String name;

    public static final Codec<Symptom> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.optionalFieldOf("name", "").forGetter(Symptom::getName)
            ).apply(instance, Symptom::new)
    );

    public static final Symptom EMPTY = new Symptom("null");

    public Symptom(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getTickingEffect(LivingEntity living) {}
    public void getHitEffect(LivingEntity living, LivingEntity target) {}
}