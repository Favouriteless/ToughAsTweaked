package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.Config;
import com.favouriteless.toughastweaks.api.ICompatHandler;
import toughasnails.api.temperature.IProximityBlockModifier.Type;
import toughasnails.api.temperature.TemperatureHelper;
import vectorwing.farmersdelight.common.block.StoveBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FarmersDelightHandler implements ICompatHandler {

	@Override
	public void init() {
		if(Config.FarmersDelight.STOVE_HEAT.get())
			TemperatureHelper.registerProximityBlockModifier((level, pos, state) -> state.is(ModBlocks.STOVE.get()) && state.getValue(StoveBlock.LIT) ? Type.HEATING : Type.NONE);
	}

}
