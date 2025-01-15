package com.github.sokyranthedragon.svtp.events.neoforge;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = SVTPMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents
{
    @SubscribeEvent
    private static void common(FMLCommonSetupEvent event)
    {
        event.enqueueWork(SVTPBlocks::registerFlammableBlocks);
    }
}
