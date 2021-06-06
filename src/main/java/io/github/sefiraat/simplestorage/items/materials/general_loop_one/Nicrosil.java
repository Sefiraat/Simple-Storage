package io.github.sefiraat.simplestorage.items.materials.general_loop_one;

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

public class Nicrosil extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_NICROSIL",
            Material.IRON_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Nicrosil Alloy Ingot",
            "",
            Messages.THEME_PASSIVE + "An alloy of Nickel, Silicon and",
            Messages.THEME_PASSIVE + "Chromium. Forms part of a thermocouple.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                SlimefunItems.NICKEL_INGOT, SlimefunItems.SILICON,      ChromiumIngot.STACK,
                null,                       null,                       null,
                null,                       null,                       null
    };

    public Nicrosil(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
