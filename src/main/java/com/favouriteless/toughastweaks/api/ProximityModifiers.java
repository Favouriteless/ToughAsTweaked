package com.favouriteless.toughastweaks.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class ProximityModifiers {

    private static final List<ProximityModifier> proximityModifiers = new ArrayList<>();

    public static List<ProximityModifier> getProximityModifiers() {
        return proximityModifiers;
    }

    public static void addModifier(ProximityModifier modifier) {
        proximityModifiers.add(modifier);
    }

    @FunctionalInterface
    public interface ProximityModifier {
        /**
         * Should return negative if the block is cold, positive if hot, or zero if neutral.
         */
        int apply(Level level, BlockPos pos, BlockState state);
    }

}
