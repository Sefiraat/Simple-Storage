package io.github.sefiraat.simplestorage.items.materials.general_loop_one;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class ChromiteChunk extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_CHROMITE_CHUNK",
            Skulls.ITEM_CHROMITE_CHUNK,
            Messages.THEME_ITEM_CRAFTING + "Chromite Chunk",
            "",
            Messages.THEME_PASSIVE + "A very rare ore. Can be processed",
            Messages.THEME_PASSIVE + "into Chromium.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Base Resource"
    );

    public static final ItemStack[] RECIPE = new ItemStack[9];

    public ChromiteChunk(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
