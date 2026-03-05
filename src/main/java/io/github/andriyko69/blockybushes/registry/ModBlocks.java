package io.github.andriyko69.blockybushes.registry;

import io.github.andriyko69.blockybushes.BlockyBushes;
import io.github.andriyko69.blockybushes.block.BerryBushFullBlock;
import io.github.andriyko69.blockybushes.block.BerryBushStemBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BlockyBushes.MOD_ID);

    public static final DeferredHolder<Block, Block> BERRY_BUSH_STEM =
            BLOCKS.register("sweet_berry_bush_stem", () ->
                    new BerryBushStemBlock(BlockBehaviour.Properties.of().
                            mapColor(MapColor.GRASS).pushReaction(PushReaction.DESTROY).strength(0.2F)
                            .sound(SoundType.GRASS).noCollission())
            );

    public static final DeferredHolder<Block, Block> BERRY_BUSH_FULL =
            BLOCKS.register("sweet_berry_bush_full", () ->
                    new BerryBushFullBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.GRASS).pushReaction(PushReaction.DESTROY).strength(0.2F)
                            .sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot)
                            .isRedstoneConductor(ModBlocks::never).isSuffocating(ModBlocks::never)
                            .isViewBlocking(ModBlocks::never))
            );

    private static boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
