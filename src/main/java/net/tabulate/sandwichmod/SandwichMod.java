package net.tabulate.sandwichmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tabulate.sandwichmod.registry.ModBlocks;
import net.tabulate.sandwichmod.registry.ModItems;

import java.util.Arrays;

public class SandwichMod implements ModInitializer {

    //Mod ID
    public static final String MOD_ID = "sandwichmod";

    //Cutting Board Entity
    public static BlockEntityType<CuttingBoardEntity> CUTTING_BOARD_ENTITY;

    //Item Group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID,"sandwichmoditemgroup"))
            .icon(() -> new ItemStack(ModItems.IRON_KNIFE))
            .appendItems(stacks -> {
                for (Item item : Arrays.asList(ModItems.IRON_KNIFE, ModItems.GOLD_KNIFE, ModItems.DIAMOND_KNIFE, ModItems.NETHERITE_KNIFE)) {
                    stacks.add(new ItemStack(item));
                }
                stacks.add(new ItemStack(ModBlocks.OAK_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.ACACIA_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.BIRCH_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.CRIMSON_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.DARK_OAK_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.JUNGLE_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.SPRUCE_CUTTING_BOARD));
                stacks.add(new ItemStack(ModBlocks.WARPED_CUTTING_BOARD));
            })
            .build();

    //Register Items
    @Override
    public void onInitialize() {
        CUTTING_BOARD_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "sandwichmod:cutting_board_entity", BlockEntityType.Builder.create(CuttingBoardEntity::new, ModBlocks.CUTTING_BOARD).build(null));
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}