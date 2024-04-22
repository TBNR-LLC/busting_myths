
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.kleiders.bustingmyths.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class BustingMythsModSounds {
	public static SoundEvent CHASE = SoundEvent.createVariableRangeEvent(new ResourceLocation("busting_myths", "chase"));

	public static void load() {
		Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation("busting_myths", "chase"), CHASE);
	}
}
