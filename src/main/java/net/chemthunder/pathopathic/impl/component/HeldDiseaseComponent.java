package net.chemthunder.pathopathic.impl.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chemthunder.pathopathic.impl.util.disease.Disease;

public record HeldDiseaseComponent(Disease disease) {
    public static final Codec<HeldDiseaseComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Disease.CODEC.optionalFieldOf("heldDisease", Disease.EMPTY).forGetter(HeldDiseaseComponent::disease)
            ).apply(instance, HeldDiseaseComponent::new)
    );
}
