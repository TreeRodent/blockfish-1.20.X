package net.treerodent.blockfish.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.treerodent.blockfish.registry.ModBlocks;
import net.treerodent.blockfish.registry.ModItems;

public class FlockfishEntity extends SchoolingFishEntity {
    public FlockfishEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState flopAnimationState = new AnimationState();
    private int flopAnimationTimeout = 0;

    private void updateAnimations() {

        if(this.isFlopping()) {
            if (this.flopAnimationTimeout <= 0) {
                this.flopAnimationTimeout = this.random.nextInt(40) + 80;
                this.flopAnimationState.start(this.age);
            } else {
                this.flopAnimationTimeout--;
            }
        } else {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.age);
            } else {
                this.idleAnimationTimeout--;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            updateAnimations();
        }
    }

    @Override
    public int getMaxGroupSize() {
        return 7;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.FLOCKFISH_BUCKET);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COD_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COD_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    public boolean isFlopping() {
        return !this.isTouchingWater(); // && this.isOnGround()
    }

    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.CAKE) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            BlockPos blockPos = this.getBlockPos();
            World world = this.getWorld();

            this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0f, 1.0f);

            if (!world.isClient) {
                for (int i = 0; i < 10; i++) {
                    this.getWorld().addParticle(ParticleTypes.CLOUD,
                            this.getX() + (this.random.nextDouble() - 0.5),
                            this.getY() + 1.0,
                            this.getZ() + (this.random.nextDouble() - 0.5),
                            0, 0, 0);
                }
                world.setBlockState(blockPos, ModBlocks.BLOCKFISH.getDefaultState());
                this.discard();
            }
        }
        return super.interactAt(player, hitPos, hand);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimAroundGoal(this, 3, 10));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(0, new TemptGoal(this, 2.5F, Ingredient.ofItems(Items.CAKE), false));
    }


    public static DefaultAttributeContainer.Builder createFlockfishAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3);
    }
}
