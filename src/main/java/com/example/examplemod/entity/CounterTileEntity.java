package com.example.examplemod.entity;

import com.example.examplemod.util.TileEntityTypeRegistry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class CounterTileEntity extends TileEntity {

    private int count = 0;

    public CounterTileEntity() {
        super(TileEntityTypeRegistry.counterTileEntity.get());
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increase(){
        count ++;
        markDirty();
        return count;
    }

    public int decrease(){
        count --;
        markDirty();
        return count;
    }

    @Override
    public void read(CompoundNBT compound) {
        count = compound.getInt("count");
        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("count",count);
        return super.write(compound);
    }
}
