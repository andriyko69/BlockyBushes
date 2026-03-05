package io.github.andriyko69.blockybushes.mixin;

import io.github.andriyko69.blockybushes.registry.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockItem.class)
public abstract class SweetBerriesPlantStemMixin {
    @Shadow
    protected abstract boolean placeBlock(BlockPlaceContext ctx, BlockState state);

    @Redirect(
            method = "place",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/BlockItem;placeBlock(Lnet/minecraft/world/item/context/BlockPlaceContext;Lnet/minecraft/world/level/block/state/BlockState;)Z"
            )
    )
    private boolean bbu_placeBlockRedirect(BlockItem self, BlockPlaceContext ctx, BlockState state) {
        ItemStack stack = ctx.getItemInHand();

        if (stack.is(Items.SWEET_BERRIES) && state.is(Blocks.SWEET_BERRY_BUSH)) {
            return placeBlock(ctx, ModBlocks.BERRY_BUSH_STEM.get().defaultBlockState());
        }

        return placeBlock(ctx, state);
    }
}