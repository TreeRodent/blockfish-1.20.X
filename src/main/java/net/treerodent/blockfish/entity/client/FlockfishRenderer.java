package net.treerodent.blockfish.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.treerodent.blockfish.Blockfish;
import net.treerodent.blockfish.entity.custom.FlockfishEntity;

public class FlockfishRenderer extends MobEntityRenderer<FlockfishEntity, FlockfishModel<FlockfishEntity>> {
    private static final Identifier TEXTURE = new Identifier(Blockfish.MOD_ID, "textures/entity/flockfish.png");

    public FlockfishRenderer(EntityRendererFactory.Context context) {
        super(context, new FlockfishModel<>(context.getPart(ModModelLayers.FLOCKFISH)), 0.2f);
    }

    @Override
    public Identifier getTexture(FlockfishEntity entity) {
        return TEXTURE;
    }

    public void setupTransforms(FlockfishEntity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);

        if(entity.isFlopping()) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90f));
        }

    }

    @Override
    public void render(FlockfishEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1, 1, 1);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
