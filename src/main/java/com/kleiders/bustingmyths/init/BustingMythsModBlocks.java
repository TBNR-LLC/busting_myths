
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.kleiders.bustingmyths.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import com.kleiders.bustingmyths.block.ChaseNoteBlockBlock;
import com.kleiders.bustingmyths.BustingMythsMod;

public class BustingMythsModBlocks {
	public static Block CHASE_NOTE_BLOCK;

	public static void load() {
		CHASE_NOTE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(BustingMythsMod.MODID, "chase_note_block"), new ChaseNoteBlockBlock());
	}

	public static void clientLoad() {
		ChaseNoteBlockBlock.clientInit();
	}
}
