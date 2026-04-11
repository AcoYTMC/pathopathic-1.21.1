package net.chemthunder.pathopathic.data.provider;

import net.chemthunder.pathopathic.impl.index.PPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PPLangGen extends FabricLanguageProvider {
    public PPLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        PPItems.ITEMS.registerLang(wrapperLookup, translationBuilder);
    }
}
