package io.github.andriyko69.blockybushes.block;

import com.mojang.serialization.MapCodec;
import io.github.andriyko69.blockybushes.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BerryBushFullBlock extends Block {
    public static final MapCodec<BerryBushFullBlock> CODEC = simpleCodec(BerryBushFullBlock::new);

    public BerryBushFullBlock(Properties props) {
        super(props);
    }

    @Override
    protected @NotNull MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state,
                              @Nullable BlockEntity be, @NotNull ItemStack tool) {
        super.playerDestroy(level, player, pos, state, be, tool);
        level.setBlock(pos, ModBlocks.BERRY_BUSH_STEM.get().defaultBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void onBlockExploded(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        super.onBlockExploded(state, level, pos, explosion);
        if (!level.isClientSide) {
            level.setBlock(pos, ModBlocks.BERRY_BUSH_STEM.get().defaultBlockState(), Block.UPDATE_ALL);
        }
    }
}