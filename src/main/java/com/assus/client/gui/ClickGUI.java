package com.assus.client.gui;

import com.assus.client.module.Module;
import com.assus.client.module.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUI extends Screen {

    public ClickGUI() {
        super(Text.literal("Assus Client"));
    }

    @Override
    protected void init() {
        int y = 40;

        for (Module m : ModuleManager.modules) {
            addDrawableChild(net.minecraft.client.gui.widget.ButtonWidget.builder(
                    Text.literal(m.name + " : " + (m.enabled ? "ON" : "OFF")),
                    b -> {
                        m.toggle();
                        b.setMessage(Text.literal(m.name + " : " + (m.enabled ? "ON" : "OFF")));
                    }
            ).dimensions(width/2 - 70, y, 140, 20).build());

            y += 25;
        }
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        renderBackground(ctx);
        ctx.drawCenteredTextWithShadow(textRenderer, "ASSUS CLIENT PRO", width/2, 15, 0xFFFFFF);
        super.render(ctx, mouseX, mouseY, delta);
    }
}
