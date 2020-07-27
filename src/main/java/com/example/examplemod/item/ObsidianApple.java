package com.example.examplemod.item;

import com.example.examplemod.util.ModGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ObsidianApple extends Item {

    private static EffectInstance effectInstance = new EffectInstance(Effects.POISON,30 * 20, 1);

    private static Food food = new Food.Builder()
            .saturation(10)//饱和度
            .hunger(20)//饥饿度
            .effect(() -> effectInstance,1)//药水效果
            .build();

    public ObsidianApple() {
        super(new Properties().food(food).group(ModGroup.obsidianGroup));
    }
}
