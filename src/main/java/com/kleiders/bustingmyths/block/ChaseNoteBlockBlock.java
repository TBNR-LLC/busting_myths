
package com.kleiders.bustingmyths.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;
import java.util.Collections;

import com.kleiders.bustingmyths.init.BustingMythsModSounds;
import com.kleiders.bustingmyths.init.BustingMythsModBlocks;

public class ChaseNoteBlockBlock extends NoteBlock {
	public static BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1f, 10f);

	public ChaseNoteBlockBlock() {
		super(PROPERTIES);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Nullable
	private ResourceLocation getCustomSoundId(Level level, BlockPos blockPos) {
		return new ResourceLocation("busting_myths", "chase");
	}

	@Override
	public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int i, int j) {
		Holder<SoundEvent> holder;
		float f;
		NoteBlockInstrument noteBlockInstrument = blockState.getValue(INSTRUMENT);
		if (noteBlockInstrument.isTunable()) {
			int k = blockState.getValue(NOTE);
			f = NoteBlock.getPitchFromNote(k);
			level.addParticle(ParticleTypes.NOTE, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.2, (double) blockPos.getZ() + 0.5, (double) k / 24.0, 0.0, 0.0);
		} else {
			f = 1.0f;
		}
		if (true) {
			ResourceLocation resourceLocation = this.getCustomSoundId(level, blockPos);
			if (resourceLocation == null) {
				return false;
			}
			holder = Holder.direct(SoundEvent.createVariableRangeEvent(resourceLocation));
		} else {
			holder = noteBlockInstrument.getSoundEvent();
		}
		//	level.playSeededSound(null, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, holder, SoundSource.RECORDS, 3.0f, f, level.random.nextLong());
		if (level instanceof ServerLevel _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, blockPos, BustingMythsModSounds.CHASE, SoundSource.NEUTRAL, 1, 1);
			}
		}
		return true;
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(BustingMythsModBlocks.CHASE_NOTE_BLOCK, RenderType.solid());
	}
}
