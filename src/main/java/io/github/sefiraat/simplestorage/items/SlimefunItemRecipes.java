package io.github.sefiraat.simplestorage.items;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class SlimefunItemRecipes {
    public static final ItemStack[] CHROMIUM_DUST = new ItemStack[] {
                SlimefunItemStacks.CHUNK_CHROMITE,    null,   null,
                null,                   null,   null,
                null,                   null,   null
    };
    public static final ItemStack[] BASTNAESITE_DUST = new ItemStack[] {
                SlimefunItemStacks.CHUNK_BASTNAESITE,    null,   null,
                null,                   null,   null,
                null,                   null,   null
    };
    public static final ItemStack[] ANTIMONY_DUST = new ItemStack[] {
                SlimefunItemStacks.CHUNK_ANTIMONY,    null,   null,
                null,                   null,   null,
                null,                   null,   null
    };
    public static final ItemStack[] RHENIUM_DUST = new ItemStack[] {
                SlimefunItemStacks.RHENIUM_CHUNK,     null,   null,
                null,                   null,   null,
                null,                   null,   null
    };
    public static final ItemStack[] CHROMIUM_INGOT = new ItemStack[] {
                SlimefunItemStacks.CHROMIUM_DUST, null,      null,
                null,               null,      null,
                null,               null,      null
    };
    public static final ItemStack[] BASTNAESITE_INGOT = new ItemStack[] {
                SlimefunItemStacks.BASTNAESITE_DUST,  null,      null,
                null,                   null,      null,
                null,                   null,      null
    };
    public static final ItemStack[] ANTIMONY_INGOT = new ItemStack[] {
                SlimefunItemStacks.ANTIMONY_DUST,  null,      null,
                null,                   null,      null,
                null,                   null,      null
    };
    public static final ItemStack[] RHENIUM_INGOT = new ItemStack[] {
                SlimefunItemStacks.RHENIUM_DUST,    null,      null,
                null,                 null,      null,
                null,                 null,      null
    };
    public static final ItemStack[] ELECTRUM_INGOT = new ItemStack[] {
                SlimefunItems.GOLD_6K,  SlimefunItems.SILVER_DUST,  null,
                null,                   null,                       null,
                null,                   null,                       null
    };
    public static final ItemStack[] CUPRONICKEL_INGOT = new ItemStack[] {
                SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.NICKEL_INGOT,
                null,                       null,                       null,
                null,                       null,                       null
    };
    public static final ItemStack[] PEWTER_INGOT = new ItemStack[] {
            SlimefunItems.TIN_INGOT,    SlimefunItems.TIN_DUST, SlimefunItems.SILVER_INGOT,
            SlimefunItems.SILVER_DUST,  null,                   null,
            null,                       null,                   null
    };
    public static final ItemStack[] NICKEL_SUPERALLOY_INGOT = new ItemStack[] {
            SlimefunItems.NICKEL_INGOT, SlimefunItems.NICKEL_INGOT, SlimefunItems.NICKEL_INGOT,
            SlimefunItems.NICKEL_INGOT, SlimefunItemStacks.RHENIUM_INGOT,         null,
            null,                       null,                       null
    };
    public static final ItemStack[] ZAMAK_1 = new ItemStack[] {
                SlimefunItems.ZINC_INGOT,   SlimefunItems.ALUMINUM_DUST,    SlimefunItems.COPPER_DUST,
                null,                       null,                           null,
                null,                       null,                           null
    };
    public static final ItemStack[] ZAMAK_3 = new ItemStack[] {
                SlimefunItemStacks.ZAMAK_2, SlimefunItems.MAGNESIUM_INGOT,  SlimefunItems.MAGNESIUM_DUST,
                null,                               null,                           null,
                null,                               null,                           null
    };
    public static ItemStack[] ZAMAK_2 = new ItemStack[] {
                SlimefunItemStacks.ZAMAK_1, SlimefunItems.COPPER_DUST,  null,
                null,         null,                       null,
                null,         null,                       null
    };
    public static final ItemStack[] NISIL = new ItemStack[] {
                SlimefunItems.NICKEL_INGOT, SlimefunItems.SILICON,      new ItemStack(Material.SAND),
                null,                       null,                       null,
                null,                       null,                       null
    };
    public static final ItemStack[] NICROSIL = new ItemStack[] {
                SlimefunItems.NICKEL_INGOT, SlimefunItems.SILICON,      SlimefunItemStacks.CHROMIUM_INGOT,
                null,                       null,                       null,
                null,                       null,                       null
    };
    public static final ItemStack[] CUPRONICKEL_REINFORCED = new ItemStack[] {
                SlimefunItemStacks.CUPRONICKEL_INGOT, SlimefunItemStacks.BASTNAESITE_INGOT, null,
                null,              null,                   null,
                null,              null,                   null
    };
    public static final ItemStack[] PEWTER_REINFORCED = new ItemStack[] {
                SlimefunItemStacks.PEWTER_INGOT,   SlimefunItemStacks.ANTIMONY_INGOT, null,
                null,           null,                null,
                null,           null,                null
    };
    public static final ItemStack[] ELECTRUM_PLATE = new ItemStack[] {
                SlimefunItemStacks.DIE_BASIC,    new SlimefunItemStack(SlimefunItemStacks.ELECTRUM_INGOT, 4),   null,
                null,              null,                                              null,
                null,              null,                                              null
    };
    public static final ItemStack[] CUPRONICKEL_PLATE = new ItemStack[] {
                SlimefunItemStacks.DIE_REINFORCED, new SlimefunItemStack(SlimefunItemStacks.CUPRONICKEL_REINFORCED, 4), null,
                null,                null,                                                          null,
                null,                null,                                                          null
    };
    public static final ItemStack[] PEWTER_PLATE = new ItemStack[] {
                SlimefunItemStacks.DIE_ADVANCED,   new SlimefunItemStack(SlimefunItemStacks.PEWTER_REINFORCED, 4), null,
                null,                null,                                             null,
                null,                null,                                             null
    };
    public static final ItemStack[] NICKEL_SUPERALLOY_PLATE = new ItemStack[] {
                SlimefunItemStacks.DIE_ADVANCED,   new SlimefunItemStack(SlimefunItemStacks.NICKEL_SUPER_INGOT, 4), null,
                null,                null,                                             null,
                null,                null,                                             null
    };
    public static final ItemStack[] COMBINED_PLATE = new ItemStack[] {
                SlimefunItemStacks.PEWTER_PLATE,   SlimefunItemStacks.NICKEL_SUPERALLOY_PLATE, null,
                null,                null,                                             null,
                null,                null,                                             null
    };
    public static final ItemStack[] DIE_BASIC = new ItemStack[] {
            SlimefunItemStacks.ZAMAK_1,   null,   null,
            null,           null,   null,
            null,           null,   null
    };
    public static final ItemStack[] DIE_REINFORCED = new ItemStack[] {
            SlimefunItemStacks.ZAMAK_2,   null,   null,
            null,           null,   null,
            null,           null,   null
    };
    public static final ItemStack[] DIE_ADVANCED = new ItemStack[] {
            SlimefunItemStacks.ZAMAK_3,   null,   null,
            null,           null,   null,
            null,           null,   null
    };
    public static final ItemStack[] THERMOCOUPLE = new ItemStack[] {
                SlimefunItemStacks.NISIL,    SlimefunItemStacks.NICROSIL, null,
                null,           null,           null,
                null,           null,           null
    };
    public static final ItemStack[] CHEST_CORE_BASIC = new ItemStack[] {
            SlimefunItemStacks.ELECTRUM_PLATE, SlimefunItemStacks.ELECTRUM_PLATE, SlimefunItemStacks.ELECTRUM_PLATE,
            SlimefunItemStacks.ELECTRUM_PLATE, SlimefunItemStacks.ANGELITE,   SlimefunItemStacks.ELECTRUM_PLATE,
            SlimefunItemStacks.ELECTRUM_PLATE, SlimefunItemStacks.THERMOCOUPLE,  SlimefunItemStacks.ELECTRUM_PLATE
    };
    public static final ItemStack[] CHEST_CORE_REINFORCED = new ItemStack[] {
            SlimefunItemStacks.CUPRONICKEL_PLATE, SlimefunItemStacks.CUPRONICKEL_PLATE, SlimefunItemStacks.CUPRONICKEL_PLATE,
            SlimefunItemStacks.CUPRONICKEL_PLATE, SlimefunItemStacks.PROUSTITE,     SlimefunItemStacks.CUPRONICKEL_PLATE,
            SlimefunItemStacks.CUPRONICKEL_PLATE, SlimefunItemStacks.THERMOCOUPLE,     SlimefunItemStacks.CUPRONICKEL_PLATE
    };
    public static final ItemStack[] CHEST_CORE_ADVANCED = new ItemStack[] {
            SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.PEWTER_PLATE,
            SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.SHORTITE, SlimefunItemStacks.PEWTER_PLATE,
            SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.THERMOCOUPLE, SlimefunItemStacks.PEWTER_PLATE
    };
    public static final ItemStack[] COMMUNICATION_BLOCK = new ItemStack[] {
            SlimefunItemStacks.ELECTRUM_PLATE,    SlimefunItems.GOLD_24K_BLOCK,     SlimefunItemStacks.ELECTRUM_PLATE,
            SlimefunItems.GOLD_24K, SlimefunItemStacks.CHEST_CORE_BASIC,             SlimefunItems.GOLD_24K,
            SlimefunItemStacks.ELECTRUM_PLATE,    new ItemStack(Material.REPEATER), SlimefunItemStacks.ELECTRUM_PLATE
    };
    public static final ItemStack[] DISPLAY_PANEL = new ItemStack[] {
            SlimefunItemStacks.CLEARQUARTZ,   SlimefunItemStacks.CLEARQUARTZ,                  SlimefunItemStacks.CLEARQUARTZ,
            SlimefunItemStacks.PEWTER_PLATE, new ItemStack(Material.REPEATER), SlimefunItemStacks.PEWTER_PLATE,
            SlimefunItemStacks.PEWTER_PLATE, SlimefunItems.BLISTERING_INGOT_3, SlimefunItemStacks.PEWTER_PLATE
    };
    public static final ItemStack[] DIE_PRESS = new ItemStack[] {
            SlimefunItemStacks.ZAMAK_1, new ItemStack(Material.PISTON), SlimefunItemStacks.ZAMAK_1,
            SlimefunItemStacks.ZAMAK_1, null,                           SlimefunItemStacks.ZAMAK_1,
            SlimefunItemStacks.ZAMAK_2, new ItemStack(Material.PISTON), SlimefunItemStacks.ZAMAK_2
    };
    public static final ItemStack[] METAL_PRESS_BASIC = new ItemStack[] {
            SlimefunItemStacks.ZAMAK_3, new ItemStack(Material.STICKY_PISTON), SlimefunItemStacks.ZAMAK_3,
            SlimefunItemStacks.ZAMAK_3, SlimefunItemStacks.DIE_BASIC,                        SlimefunItemStacks.ZAMAK_3,
            SlimefunItemStacks.ZAMAK_3, new ItemStack(Material.STICKY_PISTON), SlimefunItemStacks.ZAMAK_3
    };
    public static final ItemStack[] ENDERATOR = new ItemStack[] {
            SlimefunItemStacks.PEWTER_REINFORCED,      new ItemStack(Material.END_CRYSTAL), SlimefunItemStacks.PEWTER_REINFORCED,
            SlimefunItemStacks.CUPRONICKEL_REINFORCED, null,                                SlimefunItemStacks.CUPRONICKEL_REINFORCED,
            SlimefunItemStacks.CUPRONICKEL_REINFORCED, SlimefunItemStacks.SHORTITE,                   SlimefunItemStacks.CUPRONICKEL_REINFORCED
    };
    public static final ItemStack[] CHEST_IRON = new ItemStack[] {
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK),     new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.IRON_BLOCK), SlimefunItemStacks.CHEST_CORE_BASIC,                   new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.IRON_BLOCK), SlimefunItems.REINFORCED_ALLOY_INGOT,   new ItemStack(Material.IRON_BLOCK)
    };
    public static final ItemStack[] CHEST_GOLD = new ItemStack[] {
            SlimefunItems.GOLD_24K_BLOCK, SlimefunItemStacks.CHEST_IRON,                  SlimefunItems.GOLD_24K_BLOCK,
            SlimefunItems.GOLD_24K_BLOCK, SlimefunItemStacks.CHEST_CORE_REINFORCED,        SlimefunItems.GOLD_24K_BLOCK,
            SlimefunItems.GOLD_24K_BLOCK, SlimefunItems.BLISTERING_INGOT_3,   SlimefunItems.GOLD_24K_BLOCK
    };
    public static final ItemStack[] CHEST_DIAMOND = new ItemStack[] {
            new ItemStack(Material.DIAMOND_BLOCK), SlimefunItemStacks.CHEST_GOLD,                new ItemStack(Material.DIAMOND_BLOCK),
            new ItemStack(Material.DIAMOND_BLOCK), SlimefunItemStacks.CHEST_CORE_ADVANCED,        new ItemStack(Material.DIAMOND_BLOCK),
            new ItemStack(Material.DIAMOND_BLOCK), SlimefunItems.BOOSTED_URANIUM,  new ItemStack(Material.DIAMOND_BLOCK)
    };
    public static final ItemStack[] INVENTORY_CELL = new ItemStack[] {
            SlimefunItemStacks.CHEST_DIAMOND, new ItemStack(Material.ENDER_PEARL, 16), null,
            null,               null,                                           null,
            null,               null,                                           null,
    };
    public static final ItemStack[] CHEST_MASTER = new ItemStack[] {
            SlimefunItemStacks.COMBINED_PLATE, SlimefunItemStacks.DISPLAY_PANEL,        SlimefunItemStacks.COMBINED_PLATE,
            SlimefunItemStacks.COMBINED_PLATE, SlimefunItemStacks.CHEST_DIAMOND,        SlimefunItemStacks.COMBINED_PLATE,
            SlimefunItemStacks.COMBINED_PLATE, SlimefunItemStacks.COMMUNICATION_BLOCK,  SlimefunItemStacks.COMBINED_PLATE
    };
}
