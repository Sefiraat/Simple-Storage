package io.github.sefiraat.simplestorage.items.materials.general_loop_one;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Thermocouple extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_THERMOCOUPLE",
            Material.REPEATER,
            Messages.THEME_ITEM_CRAFTING + "Thermocouple",
            "",
            Messages.THEME_PASSIVE + "Used to test heat transfer",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                Nisil.STACK,    Nicrosil.STACK, null,
                null,           null,           null,
                null,           null,           null
    };

    public Thermocouple(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
