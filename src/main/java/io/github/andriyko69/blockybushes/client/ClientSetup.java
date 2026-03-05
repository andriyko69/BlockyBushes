package io.github.andriyko69.blockybushes.client;

import io.github.andriyko69.blockybushes.BlockyBushes;
import io.github.andriyko69.blockybushes.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = BlockyBushes.MOD_ID, value = Dist.CLIENT)
public final class ClientSetup {

    private ClientSetup() {
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BERRY_BUSH_STEM.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BERRY_BUSH_FULL.get(), RenderType.cutout());
        });
    }
}