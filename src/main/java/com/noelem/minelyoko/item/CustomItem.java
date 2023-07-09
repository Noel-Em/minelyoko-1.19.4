package com.noelem.minelyoko.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomItem {

    public Item registerItem(String id, String name, Item.Settings settings, ItemGroup group)
    {
        Item item = Registry.register(Registries.ITEM, new Identifier(id, name),
                new Item(settings));
        addItemToGroup(group, item);

        return item;
    }

    public Item registerCustomItem(String id, String name, Item customItem, ItemGroup group)
    {
        Item item = Registry.register(Registries.ITEM, new Identifier(id, name), customItem);
        addItemToGroup(group, item);

        return item;
    }

    public static void addItemToGroup(ItemGroup group, Item item)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

}
