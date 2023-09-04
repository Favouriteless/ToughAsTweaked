package com.favouriteless.toughastweaks.api.hooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface IProximityHeatSource {

	List<IProximityHeatSource> HANDLERS = new ArrayList<>();

	Type getType(Level level, BlockPos pos, BlockState state);

	enum Type {
		HEATING,
		COOLING,
		NONE
	}
}
