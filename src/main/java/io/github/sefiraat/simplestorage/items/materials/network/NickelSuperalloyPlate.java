package io.github.sefiraat.simplestorage.items.materials.network;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.diamond.DieAdvanced;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class NickelSuperalloyPlate extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_SUPER_PLATE",
            Material.BROWN_CARPET,
            Messages.THEME_ITEM_CRAFTING + "Nickel-Superalloy Plate",
            "",
            Messages.THEME_PASSIVE + "A plate made out of Nickel and Rhenium",
            Messages.THEME_PASSIVE + "a shell for advanced storage components.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                DieAdvanced.STACK,   new SlimefunItemStack(NickelSuperalloy.STACK, 4), null,
                null,                null,                                             null,
                null,                null,                                             null
    };

    public NickelSuperalloyPlate(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
