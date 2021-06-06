package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.iron.ChestCoreBasic;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ChestIron extends SimpleChest {


    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_CHEST_IRON",
            Skulls.BLOCK_CHEST_IRON,
            Messages.THEME_ITEM_MACHINE + "Iron Chest",
            "",
            Messages.THEME_PASSIVE + "A chest with 90 item slots.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Chest"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK),     new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.IRON_BLOCK), ChestCoreBasic.STACK,                   new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.IRON_BLOCK), SlimefunItems.REINFORCED_ALLOY_INGOT,   new ItemStack(Material.IRON_BLOCK)
    };

    public ChestIron(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe, 2);
        register(plugin);
    }


}
