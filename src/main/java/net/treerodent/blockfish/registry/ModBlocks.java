package net.treerodent.blockfish.registry;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;
import net.treerodent.blockfish.block.BlockfishBlock;

public class ModBlocks {

    public static final Block BLOCKFISH = registerBlock("blockfish", new BlockfishBlock(
            AbstractBlock.Settings.create()
                    .hardness(0.0f)
                    .sounds(BlockSoundGroup.SLIME)
                    .mapColor(MapColor.PINK)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Blockfish.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Blockfish.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Blockfish.LOGGER.info("Registering blocks for " + Blockfish.MOD_ID);
    }
}
