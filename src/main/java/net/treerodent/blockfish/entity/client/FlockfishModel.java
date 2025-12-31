package net.treerodent.blockfish.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.treerodent.blockfish.entity.animation.FlockfishAnimations;
import net.treerodent.blockfish.entity.custom.FlockfishEntity;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FlockfishModel<T extends FlockfishEntity> extends SinglePartEntityModel<T> {

    private final ModelPart flockfish;
	private final ModelPart front;
	private final ModelPart back;
	public FlockfishModel(ModelPart root) {
		this.flockfish = root.getChild("flockfish");
		this.front = this.flockfish.getChild("front");
		this.back = this.flockfish.getChild("back");
	}

    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData flockfish = modelPartData.addChild("flockfish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData front = flockfish.addChild("front", ModelPartBuilder.create().uv(32, 22).cuboid(2.1875F, -2.0F, -8.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 8).cuboid(1.6875F, -3.0F, -6.5F, 3.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(3.1875F, -6.0F, -4.5F, 0.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.6875F, -3.0F, -1.5F));

		ModelPartData back = flockfish.addChild("back", ModelPartBuilder.create().uv(24, 22).cuboid(-1.5F, -6.0F, 8.0F, 0.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(22, 2).cuboid(-3.0F, -6.0F, 0.0F, 3.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

    @Override
	public void setAngles(FlockfishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	    this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.updateAnimation(entity.flopAnimationState, FlockfishAnimations.FLOP, ageInTicks, 1f);
        this.updateAnimation(entity.idleAnimationState, FlockfishAnimations.IDLE, ageInTicks, 1f);
    }

    @Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		flockfish.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

	}

    @Override
    public ModelPart getPart() {
        return flockfish;
    }

}