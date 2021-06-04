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

public class Zamak3 extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ZAMAK3",
            Material.IRON_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Zamak-3",
            "",
            Messages.THEME_PASSIVE + "An alloy of Zinc, Aluminium and",
            Messages.THEME_PASSIVE + "Copper. Zamak-3 is infused with",
            Messages.THEME_PASSIVE + "Magnesium for stability",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                Zamak2.STACK, SlimefunItems.MAGNESIUM_INGOT,  SlimefunItems.MAGNESIUM_DUST,
                null,                               null,                           null,
                null,                               null,                           null
    };

    public Zamak3(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
