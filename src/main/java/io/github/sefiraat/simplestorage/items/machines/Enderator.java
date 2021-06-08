package io.github.sefiraat.simplestorage.items.machines;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.blocks.ChestDiamond;
import io.github.sefiraat.simplestorage.items.blocks.InventoryCell;
import io.github.sefiraat.simplestorage.items.materials.diamond.GemShortite;
import io.github.sefiraat.simplestorage.items.materials.diamond.PewterReinforced;
import io.github.sefiraat.simplestorage.items.materials.gold.CupronickelReinforced;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Enderator extends AContainer implements RecipeDisplayItem {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MACHINE_ENDERATOR",
            Material.RESPAWN_ANCHOR,
            Messages.THEME_ITEM_MACHINE + "Enderator",
            "",
            Messages.THEME_PASSIVE + "Utilises Ender Pearls to twist the",
            Messages.THEME_PASSIVE + "very fabric of an object into a more",
            Messages.THEME_PASSIVE + "condensed point in space.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Machine"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            PewterReinforced.STACK,      new ItemStack(Material.END_CRYSTAL), PewterReinforced.STACK,
            CupronickelReinforced.STACK, null,                                CupronickelReinforced.STACK,
            CupronickelReinforced.STACK, GemShortite.STACK,                   CupronickelReinforced.STACK
    };

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "enderator"), STACK, RECIPES::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 131072;
    public static final int CONSUMPTION = 32768;

    public Enderator(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        setCapacity(CAPACITY);
        setEnergyConsumption(CONSUMPTION);
        setProcessingSpeed(SPEED);
        register(plugin);
    }

    private void addRecipe(int seconds, ItemStack input, ItemStack output) {
        registerRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(300, new ItemStack[]{ChestDiamond.STACK, new ItemStack(Material.ENDER_PEARL, 16)}, new ItemStack[]{InventoryCell.STACK});
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.ENDER_EYE);

    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return "ENDERATOR";
    }

}
