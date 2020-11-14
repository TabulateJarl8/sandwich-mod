package net.tabulate.sandwichmod;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public class CuttingBoardEntity extends BlockEntity implements ImplementedInventory{
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public CuttingBoardEntity() {
        super(SandwichMod.CUTTING_BOARD_ENTITY);
    }

    @Override
    public DefaultedList<ItemStack> getItems(){
        return items;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag,items);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag,items);
        return super.toTag(tag);
    }
}
