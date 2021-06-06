package io.github.sefiraat.simplestorage.items.materials.gold;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CupronickelReinforced extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_REINFORCED_CUPRONICKEL",
            Material.GOLD_INGOT,
            Messages.THEME_ITEM_CRAFTING + "Reinforced Cupronickel Alloy Ingot",
            "",
            Messages.THEME_PASSIVE + "An alloy of Copper and Nickel that is",
            Messages.THEME_PASSIVE + "used for it's strength and ability to",
            Messages.THEME_PASSIVE + "withstand high pressures. This variant",
            Messages.THEME_PASSIVE + "has been reinforced with Carium.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
                Cupronickel.STACK, BastnaesiteIngot.STACK, null,
                null,              null,                   null,
                null,              null,                   null
    };

    public CupronickelReinforced(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
