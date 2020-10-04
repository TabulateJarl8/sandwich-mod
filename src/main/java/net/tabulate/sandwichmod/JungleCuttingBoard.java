package net.tabulate.sandwichmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class JungleCuttingBoard extends HorizontalFacingBlock {

    public JungleCuttingBoard(){
        super(FabricBlockSettings.copy(Blocks.JUNGLE_PLANKS));
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

}
