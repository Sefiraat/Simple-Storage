package io.github.sefiraat.simplestorage.items.materials;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Materials;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Zamak1 extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ZAMAK1",
            Material.IRON_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Zamak-1",
            "",
            Messages.THEME_PASSIVE + "An alloy of Zinc, Aluminium and",
            Messages.THEME_PASSIVE + "Copper. While this allow is not",
            Messages.THEME_PASSIVE + "the strongest, it is useful for",
            Messages.THEME_PASSIVE + "machine dies.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                SlimefunItems.ZINC_INGOT,   SlimefunItems.ALUMINUM_DUST,    SlimefunItems.COPPER_DUST,
                null,                       null,                           null,
                null,                       null,                           null
    };


    public Zamak1(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
