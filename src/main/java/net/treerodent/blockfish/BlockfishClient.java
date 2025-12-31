package net.treerodent.blockfish;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.treerodent.blockfish.registry.ModEntities;
import net.treerodent.blockfish.entity.client.FlockfishModel;
import net.treerodent.blockfish.entity.client.FlockfishRenderer;
import net.treerodent.blockfish.entity.client.ModModelLayers;
import net.treerodent.blockfish.registry.ModBlocks;

public class BlockfishClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOCKFISH, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.FLOCKFISH, FlockfishRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FLOCKFISH, FlockfishModel::getTexturedModelData);

    }
}
