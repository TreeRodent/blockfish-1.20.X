package net.treerodent.blockfish.registry;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;
import net.treerodent.blockfish.block.BlockfishBlock;

public class ModBlocks {

//    public static final Block BLOCKFISH = registerBlock("blockfish",
//            new FallingBlock(FabricBlockSettings.create()
//                    .mapColor(MapColor.PINK)
//                    .strength(0.1F, 0.6F)
//                    .sounds(BlockSoundGroup.SLIME)
//                    .nonOpaque()
//            ));

    public static final Block BLOCKFISH = registerBlock("blockfish", new BlockfishBlock(
            FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
                    .hardness(0.1f)
                    .sounds(BlockSoundGroup.SLIME)
                    .mapColor(DyeColor.PINK)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Blockfish.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Blockfish.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Blockfish.LOGGER.info("Registering blocks for " + Blockfish.MOD_ID);
    }
}
