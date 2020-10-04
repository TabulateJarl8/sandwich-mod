package net.tabulate.sandwichmod.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tabulate.sandwichmod.CuttingBoard;
import net.tabulate.sandwichmod.SandwichMod;

public class ModBlocks {

    public static final CuttingBoard CUTTING_BOARD = new CuttingBoard();
//    public static final Block CUTTING_BOARD = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(SandwichMod.MOD_ID, "cutting_board"), CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(SandwichMod.MOD_ID, "cutting_board"), new BlockItem(CUTTING_BOARD, new Item.Settings().group(SandwichMod.ITEM_GROUP)));
    }

}
