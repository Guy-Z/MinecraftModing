package com.example.examplemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ObsidianThorn extends Block {
    public ObsidianThorn() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1f;
    }
}
