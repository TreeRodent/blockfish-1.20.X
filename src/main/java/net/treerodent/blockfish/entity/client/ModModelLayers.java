package net.treerodent.blockfish.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;

public class ModModelLayers {
    public static final EntityModelLayer FLOCKFISH =
            new EntityModelLayer(new Identifier(Blockfish.MOD_ID, "net.treerodent.blockfish.entity.client.flockfish"), "main");
}
