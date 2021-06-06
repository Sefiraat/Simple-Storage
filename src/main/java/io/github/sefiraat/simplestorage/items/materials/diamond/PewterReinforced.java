package io.github.sefiraat.simplestorage.items.materials.diamond;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PewterReinforced extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_REINFORCED_PEWTER",
            Material.IRON_INGOT ,
            Messages.THEME_ITEM_CRAFTING + "Hardened Pewter Alloy Ingot",
            "",
            Messages.THEME_PASSIVE + "An alloy of Tin and Silver that is",
            Messages.THEME_PASSIVE + "used for it's durability. This variant",
            Messages.THEME_PASSIVE + "has been hardened with Antimony.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                Pewter.STACK,   AntimonyIngot.STACK, null,
                null,           null,                null,
                null,           null,                null
    };

    public PewterReinforced(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
