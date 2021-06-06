package io.github.sefiraat.simplestorage.items.materials.gold;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.Thermocouple;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ChestCoreReinforced extends SlimefunItem implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_CHEST_CORE_REINFORCED",
            Material.HEART_OF_THE_SEA,
            Messages.THEME_ITEM_CRAFTING + "Reinforced Chest Core",
            "",
            Messages.THEME_PASSIVE + "Used as the core for an gold chest.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            CupronickelPlate.STACK, CupronickelPlate.STACK, CupronickelPlate.STACK,
            CupronickelPlate.STACK, GemProustite.STACK,     CupronickelPlate.STACK,
            CupronickelPlate.STACK, Thermocouple.STACK,     CupronickelPlate.STACK
    };

    public ChestCoreReinforced(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }

}
