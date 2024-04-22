/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package com.kleiders.bustingmyths;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

import com.kleiders.bustingmyths.init.BustingMythsModSounds;
import com.kleiders.bustingmyths.init.BustingMythsModItems;
import com.kleiders.bustingmyths.init.BustingMythsModBlocks;

public class BustingMythsMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "busting_myths";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing BustingMythsMod");

		BustingMythsModBlocks.load();
		BustingMythsModItems.load();

		BustingMythsModSounds.load();

	}
}
