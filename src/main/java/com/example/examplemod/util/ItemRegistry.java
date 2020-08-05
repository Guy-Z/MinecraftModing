package com.example.examplemod.util;

import com.example.examplemod.item.ObsidianApple;
import com.example.examplemod.item.ObsidianGuiItem;
import com.example.examplemod.item.ObsidianIngot;
import com.example.examplemod.item.ObsidianSword;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> items = new DeferredRegister<>(ForgeRegistries.ITEMS,"examplemod");


    public static RegistryObject<Item> obsidianIngot = items.register("obsidian_ingot", ObsidianIngot::new);

    public static RegistryObject<Item> obsidianApple = items.register("obsidian_apple", ObsidianApple::new);

    public static RegistryObject<Item> obsidianSword = items.register("obsidian_sword", ObsidianSword::new);

    public static RegistryObject<Item> obsidianGuiItem = items.register("obsidian_gui_item", ObsidianGuiItem::new);



    public static RegistryObject<Item> obsidianBlock = items.register("obsidian_block",
            () -> new BlockItem(BlockRegistry.obsidianBlock.get(),new Item.Properties().group(ModGroup.obsidianGroup)));

    public static RegistryObject<Item> changeCube = items.register("change_cube",
            () -> new BlockItem(BlockRegistry.changeCube.get(),new Item.Properties().group(ModGroup.obsidianGroup)));

    public static RegistryObject<Item> obsidianFrame = items.register("obsidian_frame",
            () -> new BlockItem(BlockRegistry.obsidianFrame.get(),new Item.Properties().group(ModGroup.obsidianGroup)));

    public static RegistryObject<Item> obsidianThorn = items.register("obsidian_thorn",
            () -> new BlockItem(BlockRegistry.obsidianThorn.get(),new Item.Properties().group(ModGroup.obsidianGroup)));

    public static RegistryObject<Item> counter = items.register("counter",
            () -> new BlockItem(BlockRegistry.counter.get(),new Item.Properties().group(ModGroup.obsidianGroup)));

    public static RegistryObject<Item> hello_block = items.register("hello_block",
            () -> new BlockItem(BlockRegistry.hello.get(),new Item.Properties().group(ModGroup.obsidianGroup)));


}
