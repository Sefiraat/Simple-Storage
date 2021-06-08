package io.github.sefiraat.simplestorage.items.materials.network;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class NickelSuperalloy extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_SUPER_INGOT",
            Material.GOLD_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Nickel-Superalloy Ingot",
            "",
            Messages.THEME_PASSIVE + "An alloy of Nickel and Rhenium that",
            Messages.THEME_PASSIVE + "used for it's extreme temperature",
            Messages.THEME_PASSIVE + "resistance.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            SlimefunItems.NICKEL_INGOT, SlimefunItems.NICKEL_INGOT, SlimefunItems.NICKEL_INGOT,
            SlimefunItems.NICKEL_INGOT, RheniumIngot.STACK,         null,
            null,                       null,                       null
    };

    public NickelSuperalloy(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
