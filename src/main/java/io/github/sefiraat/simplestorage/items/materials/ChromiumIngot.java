package io.github.sefiraat.simplestorage.items.materials;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ChromiumIngot extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_CHROMIUM_INGOT",
            Material.IRON_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Chromium Ingot",
            "",
            Messages.THEME_PASSIVE + "A very rare metal. Used in making",
            Messages.THEME_PASSIVE + "alloys.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                ChromiumDust.STACK, null,      null,
                null,               null,      null,
                null,               null,      null
    };

    public ChromiumIngot(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
