package com.favouriteless.toughastweaks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class Config {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static ConfigValue<Boolean> DISABLE_THERMAL_TUNING;

	public static class Minecraft {
		public static ConfigValue<Boolean> ENABLE;
		public static ConfigValue<Boolean> FURNACE_HEAT;
		public static ConfigValue<Boolean> BLAST_FURNACE_HEAT;
		public static ConfigValue<Boolean> SMOKER_HEAT;
	}

	public static class Create {
		public static ConfigValue<Boolean> ENABLE;
		public static ConfigValue<Boolean> TRAINS_PREVENT_COLD;
		public static ConfigValue<Boolean> BLAZE_BURNER_HEAT;
	}

	public static class FarmersDelight {
		public static ConfigValue<Boolean> ENABLE;
		public static ConfigValue<Boolean> STOVE_HEAT;
	}

	static {
		DISABLE_THERMAL_TUNING = BUILDER.comment("Disable obtaining the thermal tuning enchantment from normal means #default false").define("disable_thermal_tuning", false);

		BUILDER.comment("*The game must be restarted for most of these to take effect");
		BUILDER.push("Minecraft Integrations");
		Minecraft.ENABLE = BUILDER.comment("Enable Minecraft integrations").define("enable_minecraft", false);
		Minecraft.FURNACE_HEAT = BUILDER.comment("Lit furnaces act as a heat source #default true").define("furnace_heat", true);
		Minecraft.BLAST_FURNACE_HEAT = BUILDER.comment("Lit blast furnaces act as a heat source #default true").define("blast_furnace_heat", true);
		Minecraft.SMOKER_HEAT = BUILDER.comment("Lit smokers act as a heat source #default true").define("smoker_heat", true);
		BUILDER.pop();

		BUILDER.push("Create Integrations");
		Create.ENABLE = BUILDER.comment("Enable Create integrations").define("enable_create", false);
		Create.TRAINS_PREVENT_COLD = BUILDER.comment("Being on a train will protect players from extreme temperatures #default true").define("trains_prevent_temperatures", true);
		Create.BLAZE_BURNER_HEAT = BUILDER.comment("Lit blaze burners act as a heat source #default true").define("blaze_burner_heat", true);
		BUILDER.pop();

		BUILDER.push("Farmer's Delight Integrations");
		FarmersDelight.ENABLE = BUILDER.comment("Enable Farmer's Delight integrations").define("enable_famers_delight", false);
		FarmersDelight.STOVE_HEAT = BUILDER.comment("Lit stoves act as a heat source #default true").define("stove_heat", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}