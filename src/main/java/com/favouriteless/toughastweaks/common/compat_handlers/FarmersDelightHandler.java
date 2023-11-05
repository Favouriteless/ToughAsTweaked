package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.Config;
import com.favouriteless.toughastweaks.api.ICompatHandler;
import com.favouriteless.toughastweaks.api.ProximityModifiers;
import vectorwing.farmersdelight.common.block.StoveBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FarmersDelightHandler implements ICompatHandler {

	@Override
	public void init() {
		if(Config.FarmersDelight.STOVE_HEAT.get())
			ProximityModifiers.addModifier((level, pos, state) -> state.is(ModBlocks.STOVE.get()) && state.getValue(StoveBlock.LIT) ? 1 : 0);
	}

}
