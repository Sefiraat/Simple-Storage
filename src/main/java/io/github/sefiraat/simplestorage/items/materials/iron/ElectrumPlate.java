package io.github.sefiraat.simplestorage.items.materials.iron;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ElectrumPlate extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ELECTRUM_PLATE",
            Material.YELLOW_CARPET,
            Messages.THEME_ITEM_CRAFTING + "Electrum Alloy Plate",
            "",
            Messages.THEME_PASSIVE + "A plate made out of Electrum used as",
            Messages.THEME_PASSIVE + "a shell for basic storage components.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                DieBasic.STACK,    new SlimefunItemStack(Electrum.STACK, 4),   null,
                null,              null,                                              null,
                null,              null,                                              null
    };

    public ElectrumPlate(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
