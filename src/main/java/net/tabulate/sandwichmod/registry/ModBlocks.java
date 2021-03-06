package net.tabulate.sandwichmod.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tabulate.sandwichmod.*;

public class ModBlocks {

    public static final CuttingBoard OAK_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard ACACIA_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard BIRCH_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard CRIMSON_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard DARK_OAK_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard JUNGLE_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard SPRUCE_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard WARPED_CUTTING_BOARD = new CuttingBoard();
    public static final CuttingBoard CUTTING_BOARD = new CuttingBoard();

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "oak_cutting_board"), OAK_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "oak_cutting_board"), new BlockItem(OAK_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "acacia_cutting_board"), ACACIA_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "acacia_cutting_board"), new BlockItem(ACACIA_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "birch_cutting_board"), BIRCH_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "birch_cutting_board"), new BlockItem(BIRCH_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "crimson_cutting_board"), CRIMSON_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "crimson_cutting_board"), new BlockItem(CRIMSON_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "dark_oak_cutting_board"), DARK_OAK_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "dark_oak_cutting_board"), new BlockItem(DARK_OAK_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "jungle_cutting_board"), JUNGLE_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "jungle_cutting_board"), new BlockItem(JUNGLE_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "spruce_cutting_board"), SPRUCE_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "spruce_cutting_board"), new BlockItem(SPRUCE_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "warped_cutting_board"), WARPED_CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "warped_cutting_board"), new BlockItem(WARPED_CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));

    }

}
