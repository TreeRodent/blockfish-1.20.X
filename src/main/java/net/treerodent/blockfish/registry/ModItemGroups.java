package net.treerodent.blockfish.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;

public class ModItemGroups {

    public static final ItemGroup BLOCKFISH_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Blockfish.MOD_ID, "blockfish"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blockfish"))
                    .icon(() -> new ItemStack(ModItems.RAW_FLOCKFISH))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLOCKFISH);
                        entries.add(ModItems.FLOCKFISH_BUCKET);
                        entries.add(ModItems.RAW_FLOCKFISH);
                        entries.add(ModItems.COOKED_FLOCKFISH);
                        entries.add(ModItems.FLOCKFISH_SPAWN_EGG);
            }).build());

    public static void registerItemGroups() {
        Blockfish.LOGGER.info("Registering Item Groups for " + Blockfish.MOD_ID);
    }
}
