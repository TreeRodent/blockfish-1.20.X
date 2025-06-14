package net.treerodent.blockfish;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.treerodent.blockfish.registry.ModBlocks;

public class BlockfishClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOCKFISH, RenderLayer.getCutout());

    }
}
