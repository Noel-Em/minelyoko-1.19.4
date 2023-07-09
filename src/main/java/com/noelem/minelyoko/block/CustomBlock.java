package com.noelem.minelyoko.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomBlock {

    public static Block registerBlock(String id, String name, FabricBlockSettings settings, ItemGroup group)
    {
        Block block = Registry.register(Registries.BLOCK, new Identifier(id, name),
                new Block(settings));
        registerBlockItem(id, name, block, group);
        return block;
    }

    public static Item registerBlockItem(String id, String name, Block block, ItemGroup group)
    {
        BlockItem bI = Registry.register(Registries.ITEM, new Identifier(id, name),
                new BlockItem(block, new FabricItemSettings()));
        addBlockItemToGroup(group, bI);

        return bI;
    }

    public static void addBlockItemToGroup(ItemGroup group, BlockItem block)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }

}
