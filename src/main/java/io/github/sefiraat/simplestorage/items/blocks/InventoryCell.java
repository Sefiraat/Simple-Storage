package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class InventoryCell extends SimpleChest {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_CELL_BASIC",
            Skulls.BLOCK_CELL_BASIC,
            Messages.THEME_ITEM_MACHINE + "Inventory Cell",
            "",
            Messages.THEME_PASSIVE + "A inventory cell with 270 item slots.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Inventory Cell"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            ChestDiamond.STACK, new ItemStack(Material.ENDER_PEARL, 16), null,
            null,               null,                                           null,
            null,               null,                                           null,
    };

    public InventoryCell(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe, 6);
        register(plugin);
    }

}
