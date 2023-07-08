package com.noelem.minelyoko;

import com.noelem.minelyoko.item.CustomItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MineLyokoClient implements ClientModInitializer {

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("example", "test_group"))
            .icon(() -> new ItemStack(Items.GLASS))
            .displayName(Text.translatable("MineLyoko"))
            .build();

    @Override
    public void onInitializeClient() {
        System.out.println("Mod Client initialized");
        System.out.println("Running MineLyoko");

    }

    public static final Item CAMERA = new CustomItem().registerItem(MineLyoko.MOD_ID, "camera",
            new FabricItemSettings().maxCount(1), ITEM_GROUP);

    public static final Item CELLPHONE = new CustomItem().registerItem(MineLyoko.MOD_ID, "cellphone",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);

    public static final Item URANIUM = new CustomItem().registerItem(MineLyoko.MOD_ID, "uranium",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);

    public static final Item SCANNER = new CustomItem().registerItem(MineLyoko.MOD_ID, "scanner",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);


}
