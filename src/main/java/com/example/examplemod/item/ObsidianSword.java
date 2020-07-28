package com.example.examplemod.item;

import com.example.examplemod.util.ItemRegistry;
import com.example.examplemod.util.ModGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ObsidianSword extends SwordItem {

    private static IItemTier iItemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2500;
        }

        @Override
        public float getEfficiency() {
            return 10.0f;
        }

        @Override
        public float getAttackDamage() {
            return 4.0f;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.obsidianIngot.get());
        }
    };

    public ObsidianSword() {
        super(iItemTier, 3, -2.4f, new Item.Properties().group(ModGroup.obsidianGroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        playerIn.getCooldownTracker().setCooldown(this, 20);

//        if (!worldIn.isRemote) {
//
//            double x = playerIn.getPosX();
//            double y = playerIn.getPosY();
//            double z = playerIn.getPosZ();
//
//            float angle = playerIn.getRotationYawHead();
//
//            double xOffset = Math.sin(Math.toRadians(-angle)) * 5;
//            double zOffset = Math.cos(Math.toRadians(-angle)) * 5;
//
//            playerIn.setPositionAndUpdate(x + xOffset, y, z + zOffset);
//
//        }

        float f7 = playerIn.rotationYaw;
        float f = playerIn.rotationPitch;
        float f1 = -MathHelper.sin(f7 * ((float)Math.PI / 180F)) * MathHelper.cos(f * ((float)Math.PI / 180F));
        float f2 = -MathHelper.sin(f * ((float)Math.PI / 180F));
        float f3 = MathHelper.cos(f7 * ((float)Math.PI / 180F)) * MathHelper.cos(f * ((float)Math.PI / 180F));
        float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
        float f5 = 3.0F * ((1.0F + (float)3) / 4.0F);
        f1 = f1 * (f5 / f4);
        f2 = f2 * (f5 / f4);
        f3 = f3 * (f5 / f4);
        playerIn.addVelocity((double)f1, (double)f2, (double)f3);
        playerIn.startSpinAttack(20);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
