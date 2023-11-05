package com.favouriteless.toughastweaks.common.compat_handlers;

import com.favouriteless.toughastweaks.Config;
import com.favouriteless.toughastweaks.api.ICompatHandler;
import com.favouriteless.toughastweaks.api.ProximityModifiers;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SmokerBlock;

public class MinecraftHandler implements ICompatHandler {

	@Override
	public void init() {
		if(Config.Minecraft.FURNACE_HEAT.get())
			ProximityModifiers.addModifier((level, pos, state) -> state.is(Blocks.FURNACE) && state.getValue(FurnaceBlock.LIT) ? 1 : 0);
		if(Config.Minecraft.BLAST_FURNACE_HEAT.get())
			ProximityModifiers.addModifier((level, pos, state) -> state.is(Blocks.BLAST_FURNACE) && state.getValue(BlastFurnaceBlock.LIT) ? 1 : 0);
		if(Config.Minecraft.SMOKER_HEAT.get())
			ProximityModifiers.addModifier((level, pos, state) -> state.is(Blocks.SMOKER) && state.getValue(SmokerBlock.LIT) ? 1 : 0);

	}


}
