package com.example.examplemod.item;

import com.example.examplemod.gui.ObsidianGui;
import com.example.examplemod.util.ModGroup;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class ObsidianGuiItem extends Item {
    public ObsidianGuiItem() {
        super(new Properties().group(ModGroup.obsidianGroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            DistExecutor.runWhenOn(Dist.CLIENT, () -> OpenGuI::openGUI);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static class OpenGuI {
        public static void openGUI() {
            Minecraft.getInstance().displayGuiScreen(new ObsidianGui(new StringTextComponent("test")));
        }
    }
}
