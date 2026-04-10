package net.chemthunder.pathopathic.impl.index;

import net.acoyt.acornlib.api.registrants.ComponentTypeRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.component.HeldDiseaseComponent;
import net.minecraft.component.ComponentType;

public interface PPDataComponents {
    ComponentTypeRegistrant DATA_COMPONENTS = new ComponentTypeRegistrant(Pathopathic.MOD_ID);

    ComponentType<HeldDiseaseComponent> HELD_DISEASE = DATA_COMPONENTS.register("held_disease", builder -> builder.codec(HeldDiseaseComponent.CODEC));

    static void init() {}
}
