package net.chemthunder.pathopathic.impl;

import net.chemthunder.pathopathic.impl.index.PPBlockEntities;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PathopathicClient implements ClientModInitializer {
    public static Disease disease = PPDiseases.EMPTY;

    public void onInitializeClient() {
        PPBlockEntities.clientInit();
    }
}
