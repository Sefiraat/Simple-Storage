package io.github.sefiraat.simplestorage.items.materials.iron;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.Zamak1;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DieBasic extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_DIE_BASIC",
            Material.LIGHT_GRAY_CARPET,
            Messages.THEME_ITEM_CRAFTING + "Basic Die",
            "",
            Messages.THEME_PASSIVE + "A weak die made out of Zamak-1.",
            Messages.THEME_PASSIVE + "Can be used to create rudimentary",
            Messages.THEME_PASSIVE + "injected shells.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            Zamak1.STACK,   null,   null,
            null,           null,   null,
            null,           null,   null
    };

    public DieBasic(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
