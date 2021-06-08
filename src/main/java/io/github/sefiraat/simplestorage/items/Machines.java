package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.Enderator;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Machines {

    public static void set(SimpleStorage plugin) {

        new DiePress(Categories.MAIN, SlimefunItemStacks.DIE_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.DIE_PRESS);
        new MetalPressBasic(Categories.MAIN, SlimefunItemStacks.METAL_PRESS_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.METAL_PRESS_BASIC);
        new Enderator(Categories.MAIN, SlimefunItemStacks.ENDERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.ENDERATOR);

    }

}
