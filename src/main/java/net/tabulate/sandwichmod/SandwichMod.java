package net.tabulate.sandwichmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tabulate.sandwichmod.registry.ModBlocks;
import net.tabulate.sandwichmod.registry.ModItems;

import java.util.Arrays;

public class SandwichMod implements ModInitializer {

    //Mod ID
    public static final String MOD_ID = "sandwichmod";

    //Item Group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID,"sandwichmoditemgroup"))
            .icon(() -> new ItemStack(ModItems.IRON_KNIFE))
            .appendItems(stacks -> {
                for (Item item : Arrays.asList(ModItems.IRON_KNIFE, ModItems.GOLD_KNIFE, ModItems.DIAMOND_KNIFE, ModItems.NETHERITE_KNIFE)) {
                    stacks.add(new ItemStack(item));
                }
                stacks.add(new ItemStack(ModBlocks.CUTTING_BOARD));
            })
            .build();

    //Register Items
    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
