package net.treerodent.blockfish.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.treerodent.blockfish.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN),
                SpawnGroup.WATER_CREATURE, ModEntities.FLOCKFISH, 20, 2, 6);

        SpawnRestriction.register(ModEntities.FLOCKFISH, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.OCEAN_FLOOR, SchoolingFishEntity::canMobSpawn);
    }
}
