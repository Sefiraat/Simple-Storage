package io.github.sefiraat.simplestorage.items.materials.network;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class RheniumChunk extends UnplaceableBlock {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_RHENIUM_CHUNK",
            Skulls.ITEM_RHENIUM_CHUNK,
            Messages.THEME_ITEM_CRAFTING + "Rhenium Shard",
            "",
            Messages.THEME_PASSIVE + "A very rare metal. Can be processed",
            Messages.THEME_PASSIVE + "into Rhenium.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Base Resource"
    );

    public static final ItemStack[] RECIPE = new ItemStack[9];

    public RheniumChunk(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
