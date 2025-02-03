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
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class SVTPBlocks
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SVTPMod.MOD_ID, Registries.BLOCK);

    // Normal and pane
    public static final RegistrySupplier<Block> ARMORED_GLASS = register("armored_glass", TransparentBlock::new, armoredGlassProperties(Blocks.GLASS));
    public static final RegistrySupplier<Block> ARMORED_GLASS_PANE = register("armored_glass_pane", IronBarsBlock::new, armoredGlassProperties(Blocks.GLASS_PANE));
    // Tinted
    public static final RegistrySupplier<Block> ARMORED_TINTED_GLASS = register("armored_tinted_glass", TintedGlassBlock::new, armoredGlassProperties(Blocks.TINTED_GLASS));
    // Stained
    public static final RegistrySupplier<Block> ARMORED_WHITE_STAINED_GLASS = registerStainedArmoredGlass("armored_white_stained_glass", Blocks.WHITE_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_ORANGE_STAINED_GLASS = registerStainedArmoredGlass("armored_orange_stained_glass", Blocks.ORANGE_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_MAGENTA_STAINED_GLASS = registerStainedArmoredGlass("armored_magenta_stained_glass", Blocks.MAGENTA_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_LIGHT_BLUE_STAINED_GLASS = registerStainedArmoredGlass("armored_light_blue_stained_glass", Blocks.LIGHT_BLUE_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_YELLOW_STAINED_GLASS = registerStainedArmoredGlass("armored_yellow_stained_glass", Blocks.YELLOW_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_LIME_STAINED_GLASS = registerStainedArmoredGlass("armored_lime_stained_glass", Blocks.LIME_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_PINK_STAINED_GLASS = registerStainedArmoredGlass("armored_pink_stained_glass", Blocks.PINK_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_GRAY_STAINED_GLASS = registerStainedArmoredGlass("armored_gray_stained_glass", Blocks.GRAY_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_LIGHT_GRAY_STAINED_GLASS = registerStainedArmoredGlass("armored_light_gray_stained_glass", Blocks.LIGHT_GRAY_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_CYAN_STAINED_GLASS = registerStainedArmoredGlass("armored_cyan_stained_glass", Blocks.CYAN_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_PURPLE_STAINED_GLASS = registerStainedArmoredGlass("armored_purple_stained_glass", Blocks.PURPLE_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_BLUE_STAINED_GLASS = registerStainedArmoredGlass("armored_blue_stained_glass", Blocks.BLUE_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_BROWN_STAINED_GLASS = registerStainedArmoredGlass("armored_brown_stained_glass", Blocks.BROWN_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_GREEN_STAINED_GLASS = registerStainedArmoredGlass("armored_green_stained_glass", Blocks.GREEN_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_RED_STAINED_GLASS = registerStainedArmoredGlass("armored_red_stained_glass", Blocks.RED_STAINED_GLASS);
    public static final RegistrySupplier<Block> ARMORED_BLACK_STAINED_GLASS = registerStainedArmoredGlass("armored_black_stained_glass", Blocks.BLACK_STAINED_GLASS);
    // Stained pane
    public static final RegistrySupplier<Block> ARMORED_WHITE_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_white_stained_glass_pane", Blocks.WHITE_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_ORANGE_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_orange_stained_glass_pane", Blocks.ORANGE_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_MAGENTA_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_magenta_stained_glass_pane", Blocks.MAGENTA_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_LIGHT_BLUE_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_light_blue_stained_glass_pane", Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_YELLOW_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_yellow_stained_glass_pane", Blocks.YELLOW_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_LIME_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_lime_stained_glass_pane", Blocks.LIME_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_PINK_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_pink_stained_glass_pane", Blocks.PINK_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_GRAY_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_gray_stained_glass_pane", Blocks.GRAY_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_LIGHT_GRAY_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_light_gray_stained_glass_pane", Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_CYAN_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_cyan_stained_glass_pane", Blocks.CYAN_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_PURPLE_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_purple_stained_glass_pane", Blocks.PURPLE_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_BLUE_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_blue_stained_glass_pane", Blocks.BLUE_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_BROWN_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_brown_stained_glass_pane", Blocks.BROWN_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_GREEN_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_green_stained_glass_pane", Blocks.GREEN_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_RED_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_red_stained_glass_pane", Blocks.RED_STAINED_GLASS_PANE);
    public static final RegistrySupplier<Block> ARMORED_BLACK_STAINED_GLASS_PANE = registerStainedArmoredPane("armored_black_stained_glass_pane", Blocks.BLACK_STAINED_GLASS_PANE);

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
            .sound(SoundType.METAL));
    public static final RegistrySupplier<Block> WALL_GOLDEN_TORCH_1 = register("wall_golden_torch_1", (props) -> new GoldenWallTorchBlock(ParticleTypes.FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_TORCH_1))
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
            .sound(SoundType.METAL));
    public static final RegistrySupplier<Block> WALL_GOLDEN_SOUL_TORCH_1 = register("wall_golden_soul_torch_1", (props) -> new GoldenWallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, props),
        BlockBehaviour.Properties
            .ofFullCopy(Blocks.WALL_TORCH)
            .lightLevel((state) -> Level.MAX_BRIGHTNESS)
            .sound(SoundType.METAL)
            .overrideDescription(descriptionIdFrom(GOLDEN_SOUL_TORCH_1))
            .overrideLootTable(lootTableFrom(GOLDEN_SOUL_TORCH_1)));

    public static final RegistrySupplier<Block> PAPER_BUNDLE_0 = register("paper_bundle_0", PaperBundleBlock::new, paperProperties());
    public static final RegistrySupplier<Block> PAPER_BUNDLE_1 = register("paper_bundle_1", PaperBundleBlock::new, paperProperties());
    public static final RegistrySupplier<Block> PAPER_BUNDLE_2 = register("paper_bundle_2", PaperBundleBlock::new, paperProperties());
    public static final RegistrySupplier<Block> PAPER_BUNDLE_3 = register("paper_bundle_3", PaperBundleBlock::new, paperProperties());

    public static final RegistrySupplier<Block> REDSTONE_LANTERN = register("redstone_lantern", RedstoneLanternBlock::new,
        BlockBehaviour.Properties
            .of()
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.STONE)
            .lightLevel(state -> state.getValue(RedstoneLanternBlock.REDSTONE_STATE) ^ state.getValue(RedstoneLanternBlock.MANUAL_STATE) ? Level.MAX_BRIGHTNESS : 0)
            .strength(0.3f, 3.5f)
            .isValidSpawn((state, getter, pos, type) -> true));

    public static final RegistrySupplier<Block> DEAD_FLOWER = register("dead_flower", (props) -> new DeadFlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 7f, props),
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

    private static BlockBehaviour.Properties armoredGlassProperties(Block base)
    {
        return BlockBehaviour.Properties
            .ofFullCopy(base)
            // 90% obsidian's strength
            .strength(Blocks.OBSIDIAN.defaultDestroyTime() * 0.75f, Blocks.OBSIDIAN.getExplosionResistance());
    }

    private static RegistrySupplier<Block> registerStainedArmoredGlass(String id, Block base)
    {
        return register(id, (props) -> new StainedGlassBlock(((StainedGlassBlock)base).getColor(), props), armoredGlassProperties(base));
    }

    private static RegistrySupplier<Block> registerStainedArmoredPane(String id, Block base)
    {
        return register(id, (props) -> new StainedGlassPaneBlock(((StainedGlassPaneBlock)base).getColor(), props), armoredGlassProperties(base));
    }

    @Contract(pure = true)
    public static RegistrySupplier<Block>[] getStainedGlassBlockProviders()
    {
        //noinspection unchecked
        return new RegistrySupplier[]
            {
                ARMORED_WHITE_STAINED_GLASS,
                ARMORED_ORANGE_STAINED_GLASS,
                ARMORED_MAGENTA_STAINED_GLASS,
                ARMORED_LIGHT_BLUE_STAINED_GLASS,
                ARMORED_YELLOW_STAINED_GLASS,
                ARMORED_LIME_STAINED_GLASS,
                ARMORED_PINK_STAINED_GLASS,
                ARMORED_GRAY_STAINED_GLASS,
                ARMORED_LIGHT_GRAY_STAINED_GLASS,
                ARMORED_CYAN_STAINED_GLASS,
                ARMORED_PURPLE_STAINED_GLASS,
                ARMORED_BLUE_STAINED_GLASS,
                ARMORED_BROWN_STAINED_GLASS,
                ARMORED_GREEN_STAINED_GLASS,
                ARMORED_RED_STAINED_GLASS,
                ARMORED_BLACK_STAINED_GLASS,
            };
    }

    @Contract(pure = true)
    public static RegistrySupplier<Block>[] getStainedGlassPaneBlockProviders()
    {
        //noinspection unchecked
        return new RegistrySupplier[]
            {
                ARMORED_WHITE_STAINED_GLASS_PANE,
                ARMORED_ORANGE_STAINED_GLASS_PANE,
                ARMORED_MAGENTA_STAINED_GLASS_PANE,
                ARMORED_LIGHT_BLUE_STAINED_GLASS_PANE,
                ARMORED_YELLOW_STAINED_GLASS_PANE,
                ARMORED_LIME_STAINED_GLASS_PANE,
                ARMORED_PINK_STAINED_GLASS_PANE,
                ARMORED_GRAY_STAINED_GLASS_PANE,
                ARMORED_LIGHT_GRAY_STAINED_GLASS_PANE,
                ARMORED_CYAN_STAINED_GLASS_PANE,
                ARMORED_PURPLE_STAINED_GLASS_PANE,
                ARMORED_BLUE_STAINED_GLASS_PANE,
                ARMORED_BROWN_STAINED_GLASS_PANE,
                ARMORED_GREEN_STAINED_GLASS_PANE,
                ARMORED_RED_STAINED_GLASS_PANE,
                ARMORED_BLACK_STAINED_GLASS_PANE,
            };
    }

    @Contract(pure = true)
    public static Block[] getStainedGlassBlocks()
    {
        return Arrays.stream(getStainedGlassBlockProviders())
            .map(Supplier::get)
            .toArray(Block[]::new);
    }

    @Contract(pure = true)
    public static Block[] getStainedGlassPaneBlocks()
    {
        return Arrays.stream(getStainedGlassPaneBlockProviders())
            .map(Supplier::get)
            .toArray(Block[]::new);
    }
}