package io.github.andriyko69.blockybushes;

import io.github.andriyko69.blockybushes.registry.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BlockyBushes.MOD_ID)
public class BlockyBushes {
    public static final String MOD_ID = "blockybushes";

    public BlockyBushes(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
    }
}
