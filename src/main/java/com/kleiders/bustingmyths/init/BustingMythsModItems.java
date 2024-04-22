
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.kleiders.bustingmyths.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import com.kleiders.bustingmyths.BustingMythsMod;

public class BustingMythsModItems {
	public static Item CHASE_NOTE_BLOCK;

	public static void load() {
		CHASE_NOTE_BLOCK = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BustingMythsMod.MODID, "chase_note_block"), new BlockItem(BustingMythsModBlocks.CHASE_NOTE_BLOCK, new Item.Properties()));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> content.accept(CHASE_NOTE_BLOCK));
	}
}
