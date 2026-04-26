package com.assus.client.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static List<Module> modules = new ArrayList<>();

    public static Module keystrokes;
    public static Module cps;
    public static Module ping;

    public static void init() {
        keystrokes = new Module("Keystrokes");
        cps = new Module("CPS");
        ping = new Module("Ping");

        modules.add(keystrokes);
        modules.add(cps);
        modules.add(ping);
    }
}
