package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.items.materials.*;
import io.github.sefiraat.simplestorage.items.other.RareDropRedstone;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.inventory.ItemStack;

public final class SlimefunItemStacks {

    public static void set(SimpleStorage plugin) {

        new Angelite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Angelite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);
        new Proustite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Proustite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);
        new ChromiteChunk(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiteChunk.STACK, RareDropRedstone.TYPE, ChromiteChunk.RECIPE);
        new ChromiumDust(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiumDust.STACK, RecipeType.ORE_CRUSHER, ChromiumDust.RECIPE);
        new ChromiumIngot(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiumIngot.STACK, RecipeType.SMELTERY, ChromiumIngot.RECIPE);
        new Electrum(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Electrum.STACK, RecipeType.SMELTERY, Electrum.RECIPE);
        new Zamak1(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak1.STACK, RecipeType.SMELTERY, Zamak1.RECIPE);
        new Zamak2(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak2.STACK, RecipeType.SMELTERY, Zamak2.RECIPE);
        new Zamak3(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak3.STACK, RecipeType.SMELTERY, Zamak3.RECIPE);
        new Nisil(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Nisil.STACK, RecipeType.SMELTERY, Nisil.RECIPE);
        new Nicrosil(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Nicrosil.STACK, RecipeType.SMELTERY, Nicrosil.RECIPE);
        new DieBasic(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieBasic.STACK, DiePress.TYPE, DieBasic.RECIPE);
        new DieReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieReinforced.STACK, DiePress.TYPE, DieReinforced.RECIPE);
        new DieAdvanced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieAdvanced.STACK, DiePress.TYPE, DieAdvanced.RECIPE);
        new ElectrumPlate(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ElectrumPlate.STACK, MetalPressBasic.TYPE, ElectrumPlate.RECIPE);
        new Thermocouple(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Thermocouple.STACK, RecipeType.HEATED_PRESSURE_CHAMBER, Thermocouple.RECIPE);
        new ChestCoreBasic(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChestCoreBasic.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestCoreBasic.RECIPE);

    }

}
