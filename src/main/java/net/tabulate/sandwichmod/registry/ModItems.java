package net.tabulate.sandwichmod.registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tabulate.sandwichmod.SandwichMod;
import net.minecraft.item.Item;

public class ModItems {

    public static final Item IRON_KNIFE = new Item(new Item.Settings().group(SandwichMod.ITEM_GROUP).maxCount(1).maxDamage(2));
    public static final Item GOLD_KNIFE = new Item(new Item.Settings().group(SandwichMod.ITEM_GROUP).maxCount(1).maxDamage(1));
    public static final Item DIAMOND_KNIFE = new Item(new Item.Settings().group(SandwichMod.ITEM_GROUP).maxCount(1).maxDamage(3));
    public static final Item NETHERITE_KNIFE = new Item(new Item.Settings().group(SandwichMod.ITEM_GROUP).maxCount(1).maxDamage(4));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "iron_knife"), IRON_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "gold_knife"), GOLD_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "diamond_knife"), DIAMOND_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "netherite_knife"), NETHERITE_KNIFE);
    }

}
