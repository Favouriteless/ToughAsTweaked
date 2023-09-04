package com.favouriteless.toughastweaks;

import com.favouriteless.toughastweaks.api.ICompatHandler;
import com.favouriteless.toughastweaks.common.compat_handlers.CompatHandlerRegistry;
import com.favouriteless.toughastweaks.common.compat_handlers.CreateHandler;
import com.favouriteless.toughastweaks.common.compat_handlers.FarmersDelightHandler;
import com.favouriteless.toughastweaks.common.compat_handlers.MinecraftHandler;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(ToughAsTweaked.MOD_ID)
public class ToughAsTweaked {

    public static final String MOD_ID = "toughastweaked";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final CompatHandlerRegistry compatHandlerReg = new CompatHandlerRegistry();

    public ToughAsTweaked() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, MOD_ID + "-common.toml");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onLoadComplete);
    }


    public void onLoadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {

            if(Config.Minecraft.ENABLE.get())
                registerCompatHandler("minecraft", MinecraftHandler::new);
            if(Config.Create.ENABLE.get())
                registerCompatHandler("create", CreateHandler::new);
            if(Config.FarmersDelight.ENABLE.get())
                registerCompatHandler("farmersdelight", FarmersDelightHandler::new);

            for(ICompatHandler handler : compatHandlerReg.getRelevantHandlers()) // Have to do this in load complete as TAN only initialises it's API in common setup.
                handler.init();
        });
    }

    public static void registerCompatHandler(String modId, Supplier<ICompatHandler> handler) {
        compatHandlerReg.register(modId, handler);
    }

}
