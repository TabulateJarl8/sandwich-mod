package net.tabulate.sandwichmod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class AcaciaCuttingBoard extends CuttingBoardBase {

    public AcaciaCuttingBoard(){
        super(FabricBlockSettings.copy(Blocks.ACACIA_PLANKS));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.WEST));
    }

}
