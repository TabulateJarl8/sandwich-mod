package net.tabulate.sandwichmod.entities.renderers;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.tabulate.sandwichmod.entities.CuttingBoardEntity;

import java.util.Objects;

public class CuttingBoardEntityRenderer extends BlockEntityRenderer<CuttingBoardEntity> {

    public CuttingBoardEntityRenderer(BlockEntityRenderDispatcher dispatcher){
        super(dispatcher);
    }

    @Override
    public void render(CuttingBoardEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        try {
            int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(blockEntity.getWorld()), blockEntity.getPos().up());
            BlockState state = blockEntity.getWorld().getBlockState(blockEntity.getPos());
            Direction o = state.get(HorizontalFacingBlock.FACING);

            ItemStack stack = blockEntity.getStack(0);
            if (!stack.isEmpty()) {
                BakedModel bakedModel = MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(stack, null, null);
                matrices.push();
                if (bakedModel.hasDepth()){
                    renderBlock(matrices, o);
                } else {
                    renderItemLayingDown(matrices, o);
                }
                MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, false, matrices, vertexConsumers, lightAbove, OverlayTexture.DEFAULT_UV, bakedModel);
                matrices.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void renderItemLayingDown(MatrixStack matrices, Direction direction){
        matrices.translate(0.5D, 0.08D, 0.5D);
        float f = -direction.getHorizontal();
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90.0F));
        matrices.scale(0.6F, 0.6F, 0.6F);
    }

    public void renderBlock(MatrixStack matrices, Direction direction){
        matrices.translate(0.5D, 0.27D, 0.5D);
        float f = -direction.getHorizontal();
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(f));
        matrices.scale(0.8F, 0.8F, 0.8F);
    }

}
