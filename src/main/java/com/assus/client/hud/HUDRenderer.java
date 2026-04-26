package com.assus.client.hud;

import com.assus.client.module.ModuleManager;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class HUDRenderer {

    public static void init() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {

            MinecraftClient mc = MinecraftClient.getInstance();

            if (mc.player == null) return;

            int y = 5;

            if (ModuleManager.cps.enabled) {
                drawContext.drawTextWithShadow(mc.textRenderer,
                        "CPS: 10",
                        5, y, 0xFFFFFF);
                y += 10;
            }

            if (ModuleManager.ping.enabled) {
                drawContext.drawTextWithShadow(mc.textRenderer,
                        "Ping: 30ms",
                        5, y, 0xFFFFFF);
                y += 10;
            }

            if (ModuleManager.keystrokes.enabled) {
                drawContext.drawTextWithShadow(mc.textRenderer,
                        "[W][A][S][D]",
                        5, y, 0xFFFFFF);
            }
        });
    }
}
