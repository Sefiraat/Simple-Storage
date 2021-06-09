package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.chests.NetworkChest;
import io.github.sefiraat.simplestorage.items.chests.SimpleChest;
import io.github.sefiraat.simplestorage.items.machines.Enderator;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;

public final class Blocks {

    private Blocks() {
        throw new IllegalStateException("Utility class");
    }

    public static void set(SimpleStorage p) {

        new SimpleChest(Categories.CHT, SlimefunItemStacks.CHEST_IRON, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_IRON, 2).register(p);
        new SimpleChest(Categories.CHT, SlimefunItemStacks.CHEST_GOLD, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_GOLD, 4).register(p);
        new SimpleChest(Categories.CHT, SlimefunItemStacks.CHEST_DIAMOND, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_DIAMOND, 6).register(p);
        new SimpleChest(Categories.CHT, SlimefunItemStacks.INVENTORY_CELL, Enderator.TYPE, SlimefunItemRecipes.INVENTORY_CELL, 6).register(p);
        new NetworkChest(Categories.CHT, SlimefunItemStacks.CHEST_NETWORK, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_MASTER).register(p);

    }

}
