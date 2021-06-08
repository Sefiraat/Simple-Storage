package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.diamond.ChestCoreAdvanced;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ChestDiamond extends SimpleChest {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_CHEST_DIAMOND",
            Skulls.BLOCK_CHEST_DIAMOND,
            Messages.THEME_ITEM_MACHINE + "Diamond Chest",
            "",
            Messages.THEME_PASSIVE + "A chest with 270 item slots.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Chest"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            new ItemStack(Material.DIAMOND_BLOCK), ChestGold.STACK,                new ItemStack(Material.DIAMOND_BLOCK),
            new ItemStack(Material.DIAMOND_BLOCK), ChestCoreAdvanced.STACK,        new ItemStack(Material.DIAMOND_BLOCK),
            new ItemStack(Material.DIAMOND_BLOCK), SlimefunItems.BOOSTED_URANIUM,  new ItemStack(Material.DIAMOND_BLOCK)
    };

    public ChestDiamond(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe, 6);
        register(plugin);
    }
}
