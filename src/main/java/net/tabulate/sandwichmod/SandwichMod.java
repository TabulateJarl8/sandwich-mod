package net.tabulate.sandwichmod;

import net.fabricmc.api.ModInitializer;
import net.tabulate.sandwichmod.registry.ModItems;

public class SandwichMod implements ModInitializer {

    public static final String MOD_ID = "sandwichmod";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
