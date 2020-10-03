package net.tabulate.sandwichmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tabulate.sandwichmod.registry.ModItems;

public class SandwichMod implements ModInitializer {

    public static final String MOD_ID = "sandwichmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "sandwichmodItemGroup"))
            .icon(() -> new ItemStack(ModItems.IRON_KNIFE))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.IRON_KNIFE));
                stacks.add(new ItemStack(ModItems.GOLD_KNIFE));
                stacks.add(new ItemStack(ModItems.DIAMOND_KNIFE));
                stacks.add(new ItemStack(ModItems.NETHERITE_KNIFE));
            })
            .build();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
