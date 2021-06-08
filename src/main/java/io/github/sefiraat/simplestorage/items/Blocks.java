package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.blocks.*;
import io.github.sefiraat.simplestorage.items.machines.Enderator;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Blocks {

    public static void set(SimpleStorage plugin) {

        new ChestIron(plugin, Categories.SIMPLE_STORAGE_MAIN, ChestIron.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestIron.RECIPE);
        new ChestGold(plugin, Categories.SIMPLE_STORAGE_MAIN, ChestGold.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestGold.RECIPE);
        new ChestDiamond(plugin, Categories.SIMPLE_STORAGE_MAIN, ChestDiamond.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestDiamond.RECIPE);
        new InventoryCell(plugin, Categories.SIMPLE_STORAGE_MAIN, InventoryCell.STACK, Enderator.TYPE, InventoryCell.RECIPE);
        new ChestMaster(plugin, Categories.SIMPLE_STORAGE_MAIN, ChestMaster.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestMaster.RECIPE);

    }

}
