package io.github.sefiraat.simplestorage.items.materials.diamond;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.Zamak3;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DieAdvanced extends UnplaceableBlock {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_DIE_ADVANCED",
            Material.BLACK_CARPET,
            Messages.THEME_ITEM_CRAFTING + "Advanced Die",
            "",
            Messages.THEME_PASSIVE + "An advanced die made out of Zamak-3.",
            Messages.THEME_PASSIVE + "Can be used to create top-tier",
            Messages.THEME_PASSIVE + "injected shells.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            Zamak3.STACK,   null,   null,
            null,           null,   null,
            null,           null,   null
    };

    public DieAdvanced(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
