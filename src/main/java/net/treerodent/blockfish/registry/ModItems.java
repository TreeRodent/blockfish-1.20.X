package net.treerodent.blockfish.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;

public class ModItems {

    public static final FoodComponent raw_flockfish_food_component = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodComponent cooked_flockfish_food_component = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.9F)
            .build();

    public static final Item FLOCKFISH_BUCKET = registerItem(
            "flockfish_bucket",
            new EntityBucketItem(ModEntities.FLOCKFISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)));

    public static final Item RAW_FLOCKFISH = registerItem(
            "raw_flockfish",
            new Item(new FabricItemSettings().food(raw_flockfish_food_component)));

    public static final Item COOKED_FLOCKFISH = registerItem(
            "cooked_flockfish",
            new Item(new FabricItemSettings().food(cooked_flockfish_food_component)));

    public static final Item FLOCKFISH_SPAWN_EGG = registerItem(
            "flockfish_spawn_egg",
            new SpawnEggItem(ModEntities.FLOCKFISH, 0xf492c4, 0xf9b4d7, new FabricItemSettings())
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Blockfish.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Blockfish.LOGGER.info("Registering mod items for " + Blockfish.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.SALMON_BUCKET, FLOCKFISH_BUCKET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKED_SALMON, RAW_FLOCKFISH);
            content.addAfter(RAW_FLOCKFISH, COOKED_FLOCKFISH);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.CONDUIT, ModBlocks.BLOCKFISH);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.addAfter(Items.SALMON_SPAWN_EGG, FLOCKFISH_SPAWN_EGG);
        });
    }
}
