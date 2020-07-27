package com.example.examplemod.util;

import com.example.examplemod.block.ChangeCube;
import com.example.examplemod.block.ObsidianBlock;
import com.example.examplemod.block.ObsidianFrame;
import com.example.examplemod.block.ObsidianThorn;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

    public static final DeferredRegister<Block> blocks = new DeferredRegister<>(ForgeRegistries.BLOCKS,"examplemod");

    public static RegistryObject<Block> obsidianBlock = blocks.register("obsidian_block", ObsidianBlock::new);

    public static RegistryObject<Block> changeCube = blocks.register("change_cube", ChangeCube::new);

    public static RegistryObject<Block> obsidianFrame = blocks.register("obsidian_frame", ObsidianFrame::new);

    public static RegistryObject<Block> obsidianThorn = blocks.register("obsidian_thorn", ObsidianThorn::new);

}
