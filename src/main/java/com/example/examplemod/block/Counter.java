package com.example.examplemod.block;

import com.example.examplemod.entity.CounterTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Counter extends Block {
    public Counter() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CounterTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(!worldIn.isRemote() && handIn == Hand.MAIN_HAND){
            CounterTileEntity counterTileEntity = (CounterTileEntity) worldIn.getTileEntity(pos);
            int count;
            Direction face = hit.getFace();
            if(face == Direction.UP){
                count = counterTileEntity.increase();
            }else if(face == Direction.DOWN){
                count = counterTileEntity.decrease();
            }else{
                double tileX = hit.getHitVec().y - hit.getPos().getY();
                if(tileX > 0.5){
                    count = counterTileEntity.increase();
                }else{
                    count = counterTileEntity.decrease();
                }
            }
            player.sendStatusMessage(
                    new TranslationTextComponent("message.examplemod.counter",count),
                    false
            );
        }

        return ActionResultType.SUCCESS;
    }

}
