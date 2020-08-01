package com.example.examplemod.util;

import com.example.examplemod.entity.CounterTileEntity;
import com.example.examplemod.entity.HelloTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER =
            new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES,"examplemod");

    public static RegistryObject<TileEntityType<CounterTileEntity>> counterTileEntity =
            TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(
                    "counter_tileentity",
                    () -> TileEntityType.Builder.create(CounterTileEntity::new, BlockRegistry.counter.get()).build(null));

    public static RegistryObject<TileEntityType<HelloTileEntity>> helloTileEntity =
            TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(
                    "hello_tileentity",
                    () -> TileEntityType.Builder.create(HelloTileEntity::new, BlockRegistry.hello.get()).build(null));

}
