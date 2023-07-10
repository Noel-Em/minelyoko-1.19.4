package com.noelem.minelyoko;

import com.noelem.minelyoko.block.CustomBlock;
import com.noelem.minelyoko.item.CustomItem;
import com.noelem.minelyoko.item.custom.UraniumItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MineLyokoClient implements ClientModInitializer {

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(MineLyoko.MOD_ID, "lyoko_items"))
            .icon(() -> new ItemStack(MineLyokoClient.URANIUM))
            .displayName(Text.translatable("Lyoko Items"))
            .build();

    private static final ItemGroup BLOCK_GROUP = FabricItemGroup.builder(new Identifier(MineLyoko.MOD_ID, "lyoko_blocks"))
            .icon(() -> new ItemStack(MineLyokoClient.URANIUM_ORE))
            .displayName(Text.translatable("Lyoko Blocks"))
            .build();

    private static final ItemGroup TECH_GROUP = FabricItemGroup.builder(new Identifier(MineLyoko.MOD_ID, "lyoko_tech"))
            .icon(() -> new ItemStack(MineLyokoClient.COPPER_WIRE))
            .displayName(Text.translatable("Lyoko Tech"))
            .build();

    @Override
    public void onInitializeClient() {
        System.out.println("Mod Client initialized");
        System.out.println("Running MineLyoko");

    }

    /* ################ ITEMS ################ */

    public static final Item URANIUM = new CustomItem().registerCustomItem(MineLyoko.MOD_ID, "uranium",
            new UraniumItem(
                    new FabricItemSettings().maxCount(64)
            ),
            ITEM_GROUP);

    public static final Item URANIUM_BATTERY = new CustomItem().registerItem(MineLyoko.MOD_ID, "uranium_battery",
            new FabricItemSettings().maxCount(1), ITEM_GROUP);


    public static final Item RAW_ALUMINUM = new CustomItem().registerItem(MineLyoko.MOD_ID, "raw_aluminum",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);

    public static final Item ALUMINUM_INGOT = new CustomItem().registerItem(MineLyoko.MOD_ID, "aluminum_ingot",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);

    public static final Item COPPER_WIRE = new CustomItem().registerItem(MineLyoko.MOD_ID, "copper_wire",
            new FabricItemSettings().maxCount(64), TECH_GROUP);

    public static final Item STATOR = new CustomItem().registerItem(MineLyoko.MOD_ID, "stator",
            new FabricItemSettings().maxCount(64), TECH_GROUP);

    public static final Item ROTOR = new CustomItem().registerItem(MineLyoko.MOD_ID, "rotor",
            new FabricItemSettings().maxCount(64), TECH_GROUP);

    public static final Item MOTOR = new CustomItem().registerItem(MineLyoko.MOD_ID, "motor",
            new FabricItemSettings().maxCount(64), TECH_GROUP);

    public static final Item CAMERA = new CustomItem().registerItem(MineLyoko.MOD_ID, "camera",
            new FabricItemSettings().maxCount(1), ITEM_GROUP);

    public static final Item CELLPHONE = new CustomItem().registerItem(MineLyoko.MOD_ID, "cellphone",
            new FabricItemSettings().maxCount(64), ITEM_GROUP);

    public static final Item STUFFED_BEAR = new CustomItem().registerItem(MineLyoko.MOD_ID, "stuffed_bear",
            new FabricItemSettings().maxCount(1), ITEM_GROUP);


    /* ################ BLOCKS ################ */

    public static final Block URANIUM_ORE = new CustomBlock().registerBlock(MineLyoko.MOD_ID, "uranium_ore",
            FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool(), BLOCK_GROUP);

    public static final Block ALUMINUM_ORE = new CustomBlock().registerBlock(MineLyoko.MOD_ID, "aluminum_ore",
            FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool(), BLOCK_GROUP);

}
