package net.tabulate.sandwichmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.tabulate.sandwichmod.entities.renderers.CuttingBoardEntityRenderer;

import static net.tabulate.sandwichmod.SandwichMod.CUTTING_BOARD_ENTITY;

public class SandwichModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockEntityRendererRegistry.INSTANCE.register(CUTTING_BOARD_ENTITY, CuttingBoardEntityRenderer::new);
    }
}
