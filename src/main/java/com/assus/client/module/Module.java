package com.assus.client.module;

public class Module {
    public String name;
    public boolean enabled;

    public Module(String name) {
        this.name = name;
    }

    public void toggle() {
        enabled = !enabled;
    }
}
