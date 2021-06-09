package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.Enderator;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Machines {

    private Machines() {
        throw new IllegalStateException("Utility class");
    }

    public static void set() {

        new DiePress(Categories.MCN, SlimefunItemStacks.DIE_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.DIE_PRESS);
        new MetalPressBasic(Categories.MCN, SlimefunItemStacks.METAL_PRESS_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.METAL_PRESS_BASIC);
        new Enderator(Categories.MCN, SlimefunItemStacks.ENDERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.ENDERATOR);

    }

}
