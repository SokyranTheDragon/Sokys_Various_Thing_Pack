package com.github.sokyranthedragon.svtp.neoforge;

import net.neoforged.fml.common.Mod;

import com.github.sokyranthedragon.svtp.SVTPMod;

@Mod(SVTPMod.MOD_ID)
public final class SVTPModNeoForge
{
    public SVTPModNeoForge()
    {
        // Run our common setup.
        SVTPMod.init();
    }
}
