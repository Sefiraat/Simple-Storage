package io.github.sefiraat.simplestorage.items.machines;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.DieBasic;
import io.github.sefiraat.simplestorage.items.materials.Zamak1;
import io.github.sefiraat.simplestorage.items.materials.Zamak3;
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

public class MetalPress extends AContainer implements RecipeDisplayItem {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MACHINE_METAL_PRESS",
            Material.STICKY_PISTON,
            Messages.THEME_ITEM_MACHINE + "Metal Press",
            "",
            Messages.THEME_PASSIVE + "A mechanical metal press that can",
            Messages.THEME_PASSIVE + "create shaped metal plates from",
            Messages.THEME_PASSIVE + "basic dies and soft alloys.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Machine"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            Zamak3.STACK, new ItemStack(Material.STICKY_PISTON), Zamak3.STACK,
            Zamak3.STACK, DieBasic.STACK,                        Zamak3.STACK,
            Zamak3.STACK, new ItemStack(Material.STICKY_PISTON), Zamak3.STACK
    };

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.getInstance(), "die-press"), STACK, RECIPES::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 32768;
    public static final int CONSUMPTION = 8192;

    public MetalPress(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
        addRecipe(20, Zamak1.STACK, DieBasic.STACK);
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
