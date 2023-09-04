package com.favouriteless.toughastweaks.mixin;

import com.favouriteless.toughastweaks.api.hooks.IProximityHeatSource;
import com.favouriteless.toughastweaks.api.hooks.IProximityHeatSource.Type;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.temperature.TemperatureHelperImpl;

import java.util.Set;

@Mixin(TemperatureHelperImpl.class)
public class MixinTemperatureHelperImpl {

	@Inject(method="addHeatingOrCooling", at=@At("HEAD"), remap = false)
	private static void addHeatingOrCooling(Set<BlockPos> checked, Set<BlockPos> heating, Set<BlockPos> cooling, Level level, BlockPos pos, CallbackInfo ci) {
		for(IProximityHeatSource handler : IProximityHeatSource.HANDLERS) {
			Type type = handler.getType(level, pos, level.getBlockState(pos));

			if(type == Type.HEATING)
				heating.add(pos);
			else if(type == Type.COOLING)
				cooling.add(pos);
		}
	}

}
