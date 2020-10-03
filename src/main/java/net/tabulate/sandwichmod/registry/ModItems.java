package net.tabulate.sandwichmod.registry;

import net.tabulate.sandwichmod.SandwichMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item IRON_KNIFE = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GOLD_KNIFE = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item DIAMOND_KNIFE = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item NETHERITE_KNIFE = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "iron_knife"), IRON_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "gold_knife"), GOLD_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "diamond_knife"), DIAMOND_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "netherite_knife"), NETHERITE_KNIFE);
    }

}
