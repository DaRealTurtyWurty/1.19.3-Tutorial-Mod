package dev.turtywurty.tutorialmod.entity;

import dev.turtywurty.tutorialmod.init.EntityInit;
import dev.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

public class ExampleEntity extends Animal {
    public ExampleEntity(EntityType<? extends ExampleEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ExampleEntity(Level level, double x, double y, double z) {
        this(EntityInit.EXAMPLE.get(), level);
        setPos(x, y, z);
    }

    public ExampleEntity(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return new ExampleEntity(pLevel, this.blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new TemptGoal(this, 1.0D, Ingredient.of(ItemInit.EXAMPLE_FOOD.get()), false));
    }

    public static AttributeSupplier.Builder createExampleAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 250.0D).add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 2);
    }

    public static boolean canSpawn(EntityType<? extends ExampleEntity> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, levelAccessor, spawnType, position, random);
    }
}
