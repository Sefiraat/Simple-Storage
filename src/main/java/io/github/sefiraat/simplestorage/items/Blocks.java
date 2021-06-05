package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.blocks.ChestIron;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Blocks {

    public static void set(SimpleStorage plugin) {

        new ChestIron(plugin, Categories.SIMPLE_STORAGE_MAIN, ChestIron.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestIron.RECIPE);


    }

}
