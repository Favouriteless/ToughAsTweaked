package com.favouriteless.toughastweaks.mixin;

import com.favouriteless.toughastweaks.api.ProximityModifiers;
import com.favouriteless.toughastweaks.api.ProximityModifiers.ProximityModifier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.temperature.TemperatureHelperImpl;

import java.util.Set;

@Mixin(TemperatureHelperImpl.class)
public class MixinTemperatureHelperImpl {

    @Inject(method="addHeatingOrCooling", at=@At("HEAD"), remap=false)
    private static void addHeatingOrCooling(Set<BlockPos> checked, Set<BlockPos> heating, Set<BlockPos> cooling, Level level, BlockPos pos, CallbackInfo ci) {
        BlockState state = level.getBlockState(pos);

        int total = 0;
        for(ProximityModifier modifier : ProximityModifiers.getProximityModifiers())
            total += modifier.apply(level, pos, state);

        if(total > 0)
            heating.add(pos);
        else if(total < 0)
            cooling.add(pos);
    }

}
