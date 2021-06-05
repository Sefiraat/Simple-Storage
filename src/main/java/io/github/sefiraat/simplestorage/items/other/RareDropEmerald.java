package io.github.sefiraat.simplestorage.items.other;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class RareDropEmerald {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MECHANIC_DROP_EMERALD",
            Material.ANCIENT_DEBRIS,
            Messages.THEME_ITEM_RARE_DROP + "Rare Drop : Emerald",
            "",
            Messages.THEME_PASSIVE + "This item is a rare drop from",
            Messages.THEME_PASSIVE + "emerald. The block actually needs",
            Messages.THEME_PASSIVE + "to break, no Silk Touch.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Drop"
    );

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.getInstance(), "drop-emerald"), STACK, RECIPES::put);

}