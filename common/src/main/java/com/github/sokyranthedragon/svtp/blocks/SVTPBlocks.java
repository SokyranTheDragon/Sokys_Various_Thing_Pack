package com.github.sokyranthedragon.svtp.blocks;

import com.github.sokyranthedragon.svtp.SVTPMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Optional;
import java.util.function.Function;

@MethodsReturnNonnullByDefault
public class SVTPBlocks
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SVTPMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> ARMORED_GLASS = register("armored_glass", TransparentBlock::new,
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.GLASS)
            // 90% obsidian's strength
            .strength(Blocks.OBSIDIAN.defaultDestroyTime() * 0.9f, Blocks.OBSIDIAN.getExplosionResistance() * 0.9f)
    );

    public static final RegistrySupplier<Block> ARMORED_GLASS_PANE = register("armored_glass_pane", IronBarsBlock::new,
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.GLASS_PANE)
            // 90% obsidian's strength
            .strength(Blocks.OBSIDIAN.defaultDestroyTime() * 0.9f, Blocks.OBSIDIAN.getExplosionResistance() * 0.9f)
    );

    public static final RegistrySupplier<Block> STONE_DOOR = register("stone_door", (props) -> new DoorBlock(BlockSetType.STONE, props),
        BlockBehaviour.Properties
            .of()
            .mapColor(MapColor.STONE)
            // Same as stone
            .instrument(NoteBlockInstrument.BASEDRUM)
            // Between iron and wooden doors
            .strength(4f)
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY)
    );

    public static final RegistrySupplier<Block> GOLDEN_TORCH_0 = register("golden_torch_0", (props) -> new GoldenTorchBlock(ParticleTypes.FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL));
    public static final RegistrySupplier<Block> WALL_GOLDEN_TORCH_0 = register("wall_golden_torch_0", (props) -> new GoldenWallTorchBlock(ParticleTypes.FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_TORCH_0))
            .overrideLootTable(lootTableFrom(GOLDEN_TORCH_0)));

    public static final RegistrySupplier<Block> GOLDEN_TORCH_1 = register("golden_torch_1", (props) -> new GoldenTorchBlock(ParticleTypes.FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_TORCH_0)));
    public static final RegistrySupplier<Block> WALL_GOLDEN_TORCH_1 = register("wall_golden_torch_1", (props) -> new GoldenWallTorchBlock(ParticleTypes.FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_TORCH_0))
            .overrideLootTable(lootTableFrom(GOLDEN_TORCH_1)));

    public static final RegistrySupplier<Block> GOLDEN_SOUL_TORCH_0 = register("golden_soul_torch_0", (props) -> new GoldenTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL));
    public static final RegistrySupplier<Block> WALL_GOLDEN_SOUL_TORCH_0 = register("wall_golden_soul_torch_0", (props) -> new GoldenWallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_SOUL_TORCH_0))
            .overrideLootTable(lootTableFrom(GOLDEN_SOUL_TORCH_0)));

    public static final RegistrySupplier<Block> GOLDEN_SOUL_TORCH_1 = register("golden_soul_torch_1", (props) -> new GoldenTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_SOUL_TORCH_0)));
    public static final RegistrySupplier<Block> WALL_GOLDEN_SOUL_TORCH_1 = register("wall_golden_soul_torch_1", (props) -> new GoldenWallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_SOUL_TORCH_0))
            .overrideLootTable(lootTableFrom(GOLDEN_SOUL_TORCH_1)));

    public static final RegistrySupplier<Block> PAPER_BUNDLE_0 = register("paper_bundle_0", PaperBundleBlock::new, paperProperties());
    public static final RegistrySupplier<Block> PAPER_BUNDLE_1 = register("paper_bundle_1", PaperBundleBlock::new, paperProperties().overrideDescription(descriptionIdFrom(PAPER_BUNDLE_0)));
    public static final RegistrySupplier<Block> PAPER_BUNDLE_2 = register("paper_bundle_2", PaperBundleBlock::new, paperProperties().overrideDescription(descriptionIdFrom(PAPER_BUNDLE_0)));
    public static final RegistrySupplier<Block> PAPER_BUNDLE_3 = register("paper_bundle_3", PaperBundleBlock::new, paperProperties().overrideDescription(descriptionIdFrom(PAPER_BUNDLE_0)));

    public static final RegistrySupplier<Block> REDSTONE_LANTERN = register("redstone_lantern", RedstoneLanternBlock::new,
        BlockBehaviour.Properties
            .of()
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.STONE)
            .lightLevel(state -> state.getValue(RedstoneLanternBlock.REDSTONE_STATE) ^ state.getValue(RedstoneLanternBlock.MANUAL_STATE) ? Level.MAX_BRIGHTNESS : 0)
            .strength(3.5f)
            .isValidSpawn((state, getter, pos, type) -> true));

    public static final RegistrySupplier<Block> DEAD_FLOWER = register("dead_flower", (props) -> new DeadFlowerBlock(MobEffects.DARKNESS, 4f, props),
        BlockBehaviour.Properties
            .of()
            .mapColor(MapColor.WOOD)
            .replaceable()
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY));
    public static final RegistrySupplier<Block> POTTED_DEAD_FLOWER = register("potted_dead_flower", (props) -> new FlowerPotBlock(DEAD_FLOWER.get(), props),
        BlockBehaviour.Properties
            .of()
            .instabreak()
            .noOcclusion()
            .pushReaction(PushReaction.DESTROY));

    public static void init()
    {
        BLOCKS.register();
    }

    public static void registerFlammableBlocks()
    {
        var fire = (FireBlock)Blocks.FIRE;

        // Match wool I guess?
        fire.setFlammable(PAPER_BUNDLE_0.get(), 30, 60);
        fire.setFlammable(PAPER_BUNDLE_1.get(), 30, 60);
        fire.setFlammable(PAPER_BUNDLE_2.get(), 30, 60);
        fire.setFlammable(PAPER_BUNDLE_3.get(), 30, 60);

        // Match dead bush
        fire.setFlammable(DEAD_FLOWER.get(), 60, 100);
    }

    private static RegistrySupplier<Block> register(String id, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties)
    {
        properties.setId(createId(id));
        return BLOCKS.register(id, () -> function.apply(properties));
    }

    private static ResourceKey<Block> createId(String id)
    {
        return ResourceKey.create(Registries.BLOCK, SVTPMod.resourceLocation(id));
    }

    private static BlockBehaviour.Properties paperProperties()
    {
        return BlockBehaviour.Properties
            .of()
            .mapColor(MapColor.SNOW)
            .sound(SoundType.WOOL)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8f)
            .ignitedByLava();
    }

    private static Optional<ResourceKey<LootTable>> lootTableFrom(RegistrySupplier<Block> parent)
    {
        // Can't access the block itself at this moment yet, need a workaround.
        var parentId = parent.getId();
        return Optional.of(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(parentId.getNamespace(), "blocks/" + parentId.getPath())));
    }

    private static String descriptionIdFrom(RegistrySupplier<Block> parent)
    {
        // Can't access the block itself at this moment yet, need a workaround.
        var parentId = parent.getId();
        return "block." + parentId.getNamespace() + "." + parentId.getPath();
    }
}