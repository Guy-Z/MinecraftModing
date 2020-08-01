package com.example.examplemod.entity;

import com.example.examplemod.util.TileEntityTypeRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class HelloTileEntity extends TileEntity implements ITickableTileEntity {

    private static int MAX_TIME = 20;

    private int time = 0;

    public HelloTileEntity() {
        super(TileEntityTypeRegistry.helloTileEntity.get());
    }

    @Override
    public void tick() {

        if(world!=null && !world.isRemote()){
            if(time == MAX_TIME){
                PlayerEntity playerEntity = world.getClosestPlayer(pos.getX(),pos.getY(),pos.getZ(),10,false);
                if(playerEntity != null){
                    playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED,2 * 20));
                }
                time = 0;
            }
            time ++;
        }
    }
}
