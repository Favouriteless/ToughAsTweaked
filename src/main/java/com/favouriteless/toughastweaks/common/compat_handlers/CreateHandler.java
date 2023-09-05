package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.Config;
import com.favouriteless.toughastweaks.api.ICompatHandler;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllEntityTypes;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock.HeatLevel;
import net.minecraft.world.entity.player.Player;
import toughasnails.api.temperature.IProximityBlockModifier.Type;
import toughasnails.api.temperature.TemperatureHelper;
import toughasnails.api.temperature.TemperatureLevel;

public class CreateHandler implements ICompatHandler {

	@Override
	public void init() {
		if(Config.Create.BLAZE_BURNER_HEAT.get())
			TemperatureHelper.registerProximityBlockModifier((level, pos, state) -> state.is(AllBlocks.BLAZE_BURNER.get()) && state.getValue(BlazeBurnerBlock.HEAT_LEVEL).isAtLeast(HeatLevel.KINDLED) ? Type.HEATING : Type.NONE);
		if(Config.Create.TRAINS_PREVENT_COLD.get())
			TemperatureHelper.registerPlayerTemperatureModifier(this::playerTempModifier);
	}


	public TemperatureLevel playerTempModifier(Player player, TemperatureLevel temp) {
		if(player.getRootVehicle().getType() == AllEntityTypes.CARRIAGE_CONTRAPTION.get()) {
			if(temp == TemperatureLevel.ICY)
				return TemperatureLevel.COLD;
			else if(temp == TemperatureLevel.HOT)
				return TemperatureLevel.WARM;
		}
		return temp;
	}

}
