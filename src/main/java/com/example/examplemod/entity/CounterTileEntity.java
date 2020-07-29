package com.example.examplemod.entity;

import com.example.examplemod.util.TileEntityTypeRegistry;
import net.minecraft.tileentity.TileEntity;

public class CounterTileEntity extends TileEntity {

    private int count = 0;

    public CounterTileEntity() {
        super(TileEntityTypeRegistry.counterTileEntity.get());
    }

    public int increase(){
        count ++;
        return count;
    }
}
