package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.api.ICompatHandler;
import net.minecraftforge.fml.ModList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class CompatHandlerRegistry {

    private final Map<String, Supplier<ICompatHandler>> handlers = new HashMap<>();

    public void register(String modId, Supplier<ICompatHandler> handlerSupplier) {
        handlers.put(modId, handlerSupplier);
    }

    public Set<ICompatHandler> getRelevantHandlers() {
        Set<ICompatHandler> out = new HashSet<>();

        ModList modList = ModList.get();
        for(String key : handlers.keySet()) {
            if(modList.isLoaded(key))
                out.add(handlers.get(key).get());
        }
        return out;
    }

}