package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Machines {



    public static void set(SimpleStorage plugin) {

        new DiePress(plugin, Categories.SIMPLE_STORAGE_MAIN, DiePress.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, DiePress.RECIPE);
        new MetalPressBasic(plugin, Categories.SIMPLE_STORAGE_MAIN, MetalPressBasic.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, MetalPressBasic.RECIPE);

    }

}
