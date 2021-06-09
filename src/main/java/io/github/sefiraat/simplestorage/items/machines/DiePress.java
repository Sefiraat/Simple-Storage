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

public final class DiePress extends AContainer implements RecipeDisplayItem {

    private static final RecipeMap<ItemStack> RECIPE_MAP = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "die-press"), SlimefunItemStacks.DIE_PRESS, RECIPE_MAP::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 16384;
    public static final int CONSUMPTION = 4096;

    public DiePress(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        setCapacity(CAPACITY);
        setEnergyConsumption(CONSUMPTION);
        setProcessingSpeed(SPEED);
        register(SimpleStorage.inst());
    }

    private void addRecipe(int seconds, ItemStack input, ItemStack output) {
        registerRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }

    @Override
    protected void registerDefaultRecipes() {
        addRecipe(20, SlimefunItemStacks.ZAMAK_1, SlimefunItemStacks.DIE_BASIC);
        addRecipe(30, SlimefunItemStacks.ZAMAK_2, SlimefunItemStacks.DIE_REINFORCED);
        addRecipe(40, SlimefunItemStacks.ZAMAK_3, SlimefunItemStacks.DIE_ADVANCED);
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.PISTON);

    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return "DIE_PRESS";
    }

}
