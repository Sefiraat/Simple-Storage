package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.gold.ChestCoreReinforced;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public final class ChestGold extends SimpleChest {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_CHEST_GOLD",
            Skulls.BLOCK_CHEST_GOLD,
            Messages.THEME_ITEM_MACHINE + "Gold Chest",
            "",
            Messages.THEME_PASSIVE + "A chest with 180 item slots.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Chest"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            SlimefunItems.GOLD_24K_BLOCK, ChestIron.STACK,                  SlimefunItems.GOLD_24K_BLOCK,
            SlimefunItems.GOLD_24K_BLOCK, ChestCoreReinforced.STACK,        SlimefunItems.GOLD_24K_BLOCK,
            SlimefunItems.GOLD_24K_BLOCK, SlimefunItems.BLISTERING_INGOT_3,   SlimefunItems.GOLD_24K_BLOCK
    };

    public ChestGold(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe, 4);
        register(plugin);
    }

}
