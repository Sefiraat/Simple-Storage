package io.github.sefiraat.simplestorage.items.other;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Theme;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public final class RareDropQuartz {

    private RareDropQuartz() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MECHANIC_DROP_QUARTZ",
            Material.NETHER_QUARTZ_ORE,
            Theme.ITEM_RARE_DROP + "Rare Drop: Quartz",
            "",
            Theme.PASSIVE + "This item is a rare drop from",
            Theme.PASSIVE + "quartz ore. The block actually needs",
            Theme.PASSIVE + "to break, no Silk Touch.",
            "",
            Theme.LORE_TYPE_DROP
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "drop-quartz"), STACK, RECIPES::put);

}