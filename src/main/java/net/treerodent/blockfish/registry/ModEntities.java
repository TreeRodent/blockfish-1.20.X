package net.treerodent.blockfish.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.treerodent.blockfish.Blockfish;
import net.treerodent.blockfish.entity.custom.FlockfishEntity;

public class ModEntities {

    public static final EntityType<FlockfishEntity> FLOCKFISH = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Blockfish.MOD_ID, "flockfish"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, FlockfishEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.3f)).build());

    public static void registerModEntities() {

        Blockfish.LOGGER.info("Registering Entities for " + Blockfish.MOD_ID);

    }

}
