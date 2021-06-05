package io.github.sefiraat.simplestorage.items.materials;

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

public class Pewter extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_PEWTER",
            Material.IRON_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Pewter Alloy Ingot",
            "",
            Messages.THEME_PASSIVE + "An alloy of Tin and Silver that is",
            Messages.THEME_PASSIVE + "used for it's durability.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            SlimefunItems.TIN_INGOT,    SlimefunItems.TIN_DUST, SlimefunItems.SILVER_INGOT,
            SlimefunItems.SILVER_DUST,  null,                   null,
            null,                       null,                   null
    };

    public Pewter(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
