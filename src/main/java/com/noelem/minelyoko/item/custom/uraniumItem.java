package com.noelem.minelyoko.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Spliterator;

public class UraniumItem extends Item {

    public UraniumItem(Settings settings)
    {
        super(settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!world.isClient())
        {
            System.out.println(EquipmentSlot.values());
            if(entity instanceof LivingEntity livingEntity )
            {

                for (ItemStack i:
                     livingEntity.getArmorItems()) {
                    //livingEntity.sendMessage(Text.literal(i.getItem().toString()));
                    if(i.getItem().toString() != "diamond_chestplate" &&
                            i.getItem().toString() != "diamond_leggings" &&
                            i.getItem().toString() != "diamond_boots" &&
                            i.getItem().toString() != "diamond_helmet")
                    {
                        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600));
                        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 4));
                    }
                }

            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
