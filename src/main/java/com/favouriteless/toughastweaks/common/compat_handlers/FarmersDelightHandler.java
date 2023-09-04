package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.Config;
import com.favouriteless.toughastweaks.api.ICompatHandler;
import com.favouriteless.toughastweaks.api.hooks.IProximityHeatSource;
import com.favouriteless.toughastweaks.api.hooks.IProximityHeatSource.Type;
import vectorwing.farmersdelight.common.block.StoveBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FarmersDelightHandler implements ICompatHandler {

	@Override
	public void init() {
		if(Config.FarmersDelight.STOVE_HEAT.get())
			IProximityHeatSource.HANDLERS.add((level, pos, state) -> state.is(ModBlocks.STOVE.get()) && state.getValue(StoveBlock.LIT) ? Type.HEATING : Type.NONE);
	}

}
