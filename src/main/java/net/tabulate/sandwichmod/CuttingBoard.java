package net.tabulate.sandwichmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CuttingBoard extends HorizontalFacingBlock  {

    public CuttingBoard() {
        super(FabricBlockSettings.of(Material.WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2, 3.0f).allowsSpawning(null));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.WEST));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager){
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir){
            case NORTH:
            case SOUTH:
                return VoxelShapes.cuboid(0.1875f, 0f, 0.0625f, 0.8125f, 0.09375f, 0.9375f);
            default:
                return VoxelShapes.cuboid(0.0625f, 0f, 0.1875f, 0.9375f, 0.09375f, 0.8125f);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx){
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return hasTopRim(world, blockPos) || sideCoversSmallSquare(world, blockPos, Direction.UP);
    }
    
//    @Override
//    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
//        if (world.isClient) return ActionResult.SUCCESS;
//        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);
//
//
//        if (!player.getStackInHand(hand).isEmpty()) {
//            // Check what is the first open slot and put an item from the player's hand there
//            if (blockEntity.getStack(0).isEmpty()) {
//                // Put the stack the player is holding into the inventory
//                blockEntity.setStack(0, player.getStackInHand(hand).copy());
//                // Remove the stack from the player's hand
//                player.getStackInHand(hand).setCount(0);
//            } else if (blockEntity.getStack(1).isEmpty()) {
//                blockEntity.setStack(1, player.getStackInHand(hand).copy());
//                player.getStackInHand(hand).setCount(0);
//            } else {
//                // If the inventory is full we'll print it's contents
//                System.out.println("The first slot holds "
//                        + blockEntity.getStack(0) + " and the second slot holds " + blockEntity.getStack(1));
//            }
//        }
//        return ActionResult.SUCCESS;
//    }
}
