package io.github.sefiraat.simplestorage.items.machines;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.SlimefunItemStacks;
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

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "enderator"), SlimefunItemStacks.ENDERATOR, RECIPES::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 131072;
    public static final int CONSUMPTION = 32768;

    public Enderator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        setCapacity(CAPACITY);
        setEnergyConsumption(CONSUMPTION);
        setProcessingSpeed(SPEED);
        register(SimpleStorage.inst());
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(300, new ItemStack[]{SlimefunItemStacks.CHEST_DIAMOND, new ItemStack(Material.ENDER_PEARL, 16)}, new ItemStack[]{SlimefunItemStacks.INVENTORY_CELL});
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
