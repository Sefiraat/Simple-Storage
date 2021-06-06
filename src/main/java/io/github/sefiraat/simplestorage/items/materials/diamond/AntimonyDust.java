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

public class AntimonyDust extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ANTIMONY_DUST",
            Material.GUNPOWDER,
            Messages.THEME_ITEM_CRAFTING + "Antimony Dust",
            "",
            Messages.THEME_PASSIVE + "A very rare metal. Needs to be worked.",
            Messages.THEME_PASSIVE + "into ingots.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                AntimonyChunk.STACK,    null,   null,
                null,                   null,   null,
                null,                   null,   null
    };

    public AntimonyDust(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
