package com.favouriteless.toughastweaks.mixin;

import com.favouriteless.toughastweaks.Config;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import toughasnails.api.enchantment.TANEnchantments;

@Mixin(Enchantment.class)
public class MixinEnchantment {

	@Inject(method="isDiscoverable", at=@At("HEAD"), cancellable = true)
	private void isDiscoverable(CallbackInfoReturnable<Boolean> cir) {
		if(Config.DISABLE_THERMAL_TUNING.get() && (Object)this == TANEnchantments.THERMAL_TUNING.get()) {
			cir.setReturnValue(false);
		}
	}

}
