package com.example.examplemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ObsidianThorn extends Block {
    public ObsidianThorn() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5).notSolid());
    }
}
