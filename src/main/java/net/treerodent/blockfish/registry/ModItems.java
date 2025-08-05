package net.treerodent.blockfish.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
            new EntityBucketItem(EntityType.CHICKEN, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)));

    public static final Item RAW_FLOCKFISH = registerItem(
            "raw_flockfish",
            new Item(new FabricItemSettings().food(raw_flockfish_food_component)));

    public static final Item COOKED_FLOCKFISH = registerItem(
            "cooked_flockfish",
            new Item(new FabricItemSettings().food(cooked_flockfish_food_component)));




    private static void addItemsToToolsTab(FabricItemGroupEntries entries ) {
        entries.add(FLOCKFISH_BUCKET);
    }

    private static void addItemsToFoodAndDrinkTab(FabricItemGroupEntries entries) {
        entries.add(RAW_FLOCKFISH);
        entries.add(COOKED_FLOCKFISH);
    }

    private static void addItemsToFunctionalBlocksTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.BLOCKFISH);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Blockfish.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Blockfish.LOGGER.info("Registering mod items for " + Blockfish.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalBlocksTab);
    }
}
