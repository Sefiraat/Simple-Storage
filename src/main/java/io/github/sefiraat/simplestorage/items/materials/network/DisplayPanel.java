package io.github.sefiraat.simplestorage.items.materials.network;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.diamond.PewterPlate;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DisplayPanel extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_DISPLAY",
            Material.GRAY_STAINED_GLASS_PANE,
            Messages.THEME_ITEM_CRAFTING + "Display Panel",
            "",
            Messages.THEME_PASSIVE + "A display panel. Used to craft the",
            Messages.THEME_PASSIVE + "Chest Master.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            GemQuartz.STACK,   GemQuartz.STACK,                  GemQuartz.STACK,
            PewterPlate.STACK, new ItemStack(Material.REPEATER), PewterPlate.STACK,
            PewterPlate.STACK, SlimefunItems.BLISTERING_INGOT_3, PewterPlate.STACK
    };

    public DisplayPanel(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
