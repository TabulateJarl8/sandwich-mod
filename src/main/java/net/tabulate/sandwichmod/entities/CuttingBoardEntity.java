package net.tabulate.sandwichmod.entities;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;
import net.tabulate.sandwichmod.ImplementedInventory;
import net.tabulate.sandwichmod.SandwichMod;

public class CuttingBoardEntity extends BlockEntity implements ImplementedInventory, BlockEntityClientSerializable {
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

    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        fromTag(getCachedState(), compoundTag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        return toTag(compoundTag);
    }

    @Override
    public void markDirty(){
        System.out.println("yayyyyyyyyyyyy");
        super.markDirty();
        if(!this.world.isClient){
            for(Object obj : PlayerStream.watching(this).toArray()){
                ServerPlayerEntity player = (ServerPlayerEntity) obj;
                player.networkHandler.sendPacket(this.toUpdatePacket());
            }
        }
    }
}
