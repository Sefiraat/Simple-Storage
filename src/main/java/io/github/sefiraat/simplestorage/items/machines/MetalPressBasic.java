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

public class MetalPressBasic extends AContainer implements RecipeDisplayItem {

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "metal-press"), SlimefunItemStacks.METAL_PRESS_BASIC, RECIPES::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 32768;
    public static final int CONSUMPTION = 8192;

    public MetalPressBasic(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        setCapacity(CAPACITY);
        setEnergyConsumption(CONSUMPTION);
        setProcessingSpeed(SPEED);
        register(SimpleStorage.inst());
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(20, new ItemStack[]{SlimefunItemStacks.DIE_BASIC, new SlimefunItemStack(SlimefunItemStacks.ELECTRUM_INGOT, 4)}, new ItemStack[]{SlimefunItemStacks.ELECTRUM_PLATE});
        registerRecipe(40, new ItemStack[]{SlimefunItemStacks.DIE_REINFORCED, new SlimefunItemStack(SlimefunItemStacks.CUPRONICKEL_REINFORCED, 4)}, new ItemStack[]{SlimefunItemStacks.CUPRONICKEL_PLATE});
        registerRecipe(60, new ItemStack[]{SlimefunItemStacks.DIE_ADVANCED, new SlimefunItemStack(SlimefunItemStacks.PEWTER_REINFORCED, 4)}, new ItemStack[]{SlimefunItemStacks.PEWTER_PLATE});
        registerRecipe(120, new ItemStack[]{SlimefunItemStacks.DIE_ADVANCED, new SlimefunItemStack(SlimefunItemStacks.NICKEL_SUPER_INGOT, 4)}, new ItemStack[]{SlimefunItemStacks.NICKEL_SUPERALLOY_PLATE});
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.PISTON);

    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return "METAL_PRESS";
    }

}
