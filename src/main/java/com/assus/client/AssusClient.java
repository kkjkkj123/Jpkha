package com.assus.client;

import com.assus.client.gui.ClickGUI;
import com.assus.client.hud.HUDRenderer;
import com.assus.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AssusClient implements ClientModInitializer {

    public static KeyBinding keyOpen;

    @Override
    public void onInitializeClient() {

        ModuleManager.init();
        HUDRenderer.init();

        keyOpen = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.assus.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                "Assus Client"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyOpen.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new ClickGUI());
            }
        });

        System.out.println("Assus Client PRO iniciado!");
    }
}
