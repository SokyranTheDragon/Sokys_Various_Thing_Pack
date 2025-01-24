package com.github.sokyranthedragon.svtp.fabric;

import com.github.sokyranthedragon.svtp.worldgen.fabric.SVTPFabricWorldGen;
import net.fabricmc.api.ModInitializer;

import com.github.sokyranthedragon.svtp.SVTPMod;

public final class SVTPModFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        SVTPMod.init();

        // Fabric doesn't need to wait to call either of those, but NeoForge does.
        SVTPMod.lateInit();

        SVTPFabricWorldGen.initWorldGen();
    }
}
