package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.materials.*;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.inventory.ItemStack;

public final class SlimefunItemStacks {

    public static void set(SimpleStorage plugin) {

        new Angelite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Angelite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);
        new Electrum(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Electrum.STACK, RecipeType.SMELTERY, Electrum.RECIPE);
        new Zamak1(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak1.STACK, RecipeType.SMELTERY, Zamak1.RECIPE);
        new Zamak2(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak2.STACK, RecipeType.SMELTERY, Zamak2.RECIPE);
        new Zamak3(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak3.STACK, RecipeType.SMELTERY, Zamak3.RECIPE);
        new DieBasic(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieBasic.STACK, DiePress.TYPE, DieBasic.RECIPE);
        new DieReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieReinforced.STACK, DiePress.TYPE, DieReinforced.RECIPE);
        new DieAdvanced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieAdvanced.STACK, DiePress.TYPE, DieAdvanced.RECIPE);

    }

}
