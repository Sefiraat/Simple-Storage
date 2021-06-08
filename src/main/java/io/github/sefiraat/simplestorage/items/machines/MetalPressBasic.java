package io.github.sefiraat.simplestorage.items.machines;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.diamond.DieAdvanced;
import io.github.sefiraat.simplestorage.items.materials.diamond.PewterPlate;
import io.github.sefiraat.simplestorage.items.materials.diamond.PewterReinforced;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.Zamak3;
import io.github.sefiraat.simplestorage.items.materials.gold.CupronickelPlate;
import io.github.sefiraat.simplestorage.items.materials.gold.CupronickelReinforced;
import io.github.sefiraat.simplestorage.items.materials.gold.DieReinforced;
import io.github.sefiraat.simplestorage.items.materials.iron.DieBasic;
import io.github.sefiraat.simplestorage.items.materials.iron.Electrum;
import io.github.sefiraat.simplestorage.items.materials.iron.ElectrumPlate;
import io.github.sefiraat.simplestorage.items.materials.network.NickelSuperalloy;
import io.github.sefiraat.simplestorage.items.materials.network.NickelSuperalloyPlate;
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

public class MetalPressBasic extends AContainer implements RecipeDisplayItem {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MACHINE_METAL_PRESS_BASIC",
            Material.STICKY_PISTON,
            Messages.THEME_ITEM_MACHINE + "Basic Metal Press",
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
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "metal-press"), STACK, RECIPES::put);
    public static final int SPEED = 1;
    public static final int CAPACITY = 32768;
    public static final int CONSUMPTION = 8192;

    public MetalPressBasic(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        setCapacity(CAPACITY);
        setEnergyConsumption(CONSUMPTION);
        setProcessingSpeed(SPEED);
        register(plugin);
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(20, new ItemStack[]{DieBasic.STACK, new SlimefunItemStack(Electrum.STACK, 4)}, new ItemStack[]{ElectrumPlate.STACK});
        registerRecipe(40, new ItemStack[]{DieReinforced.STACK, new SlimefunItemStack(CupronickelReinforced.STACK, 4)}, new ItemStack[]{CupronickelPlate.STACK});
        registerRecipe(60, new ItemStack[]{DieAdvanced.STACK, new SlimefunItemStack(PewterReinforced.STACK, 4)}, new ItemStack[]{PewterPlate.STACK});
        registerRecipe(120, new ItemStack[]{DieAdvanced.STACK, new SlimefunItemStack(NickelSuperalloy.STACK, 4)}, new ItemStack[]{NickelSuperalloyPlate.STACK});
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
