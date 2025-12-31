package net.treerodent.blockfish;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.treerodent.blockfish.registry.ModEntities;
import net.treerodent.blockfish.entity.custom.FlockfishEntity;
import net.treerodent.blockfish.registry.ModBlocks;
import net.treerodent.blockfish.registry.ModItemGroups;
import net.treerodent.blockfish.registry.ModItems;
import net.treerodent.blockfish.registry.ModEntitySpawns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockfish implements ModInitializer {
	public static final String MOD_ID = "blockfish";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModEntities.registerModEntities();
        ModEntitySpawns.addSpawns();


        FabricDefaultAttributeRegistry.register(ModEntities.FLOCKFISH, FlockfishEntity.createFlockfishAttributes());

	}
}