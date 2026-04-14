package net.chemthunder.pathopathic.impl.util;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.StringHelper;

import java.util.Arrays;
import java.util.List;

public class DiseaseHud {
    public static void render(DrawContext context) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {
            DiseaseComponent component = DiseaseComponent.KEY.get(player);

            if (component.getDisease() != PPDiseases.EMPTY) {
                if (client.world != null) {
                    MutableText duration;
                    if (component.getDuration() != -1) {
                        duration = Text.literal(StringHelper.formatTicks(component.getDuration(), client.world.getTickManager().getTickRate())).formatted(Formatting.DARK_GRAY);
                    } else {
                        duration = Text.literal("∞").formatted(Formatting.DARK_GRAY);
                    }

                    Symptom primary = component.getDisease().primary().value();
                    Symptom secondary = component.getDisease().secondary().value();

                    List<Text> contents = Arrays.asList(
                            Text.literal(MiscUtils.formatString(component.getDisease().name()))
                                    .withColor(0xFFC6FC6F),
                            Text.literal(MiscUtils.formatString(primary.getName()))
                                    .withColor(0xFFC6FC6F)
                                    .append(", ")
                                    .append(Text.literal(MiscUtils.formatString(secondary.getName()))
                                            .withColor(0xFFC6FC6F)),
                            duration
                    );

                    context.drawTooltip(client.textRenderer,
                            contents,
                            context.getScaledWindowWidth() / 2 + 90,
                            context.getScaledWindowHeight() / 2 + 90
                    );
                }
            }
        }
    }

//    public static Text getDurationText(Disease disease, float multiplier, float tickRate) {
//        if (effect.isInfinite()) {
//            return Text.translatable("effect.duration.infinite");
//        } else {
//            int i = MathHelper.floor((float)effect.getDuration() * multiplier);
//            return Text.literal(StringHelper.formatTicks(i, tickRate));
//        }
//    }
}
