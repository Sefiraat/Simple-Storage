package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.items.materials.diamond.*;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.*;
import io.github.sefiraat.simplestorage.items.materials.gold.*;
import io.github.sefiraat.simplestorage.items.materials.iron.*;
import io.github.sefiraat.simplestorage.items.other.RareDropDiamond;
import io.github.sefiraat.simplestorage.items.other.RareDropEmerald;
import io.github.sefiraat.simplestorage.items.other.RareDropRedstone;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.inventory.ItemStack;

public final class SlimefunItemStacks {

    public static void set(SimpleStorage plugin) {

        new GemAngelite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, GemAngelite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);
        new GemProustite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, GemProustite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);
        new GemShortite(plugin, Categories.SIMPLE_STORAGE_MATERIALS, GemShortite.STACK, RecipeType.GEO_MINER, new ItemStack[9]);

        new ChromiteChunk(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiteChunk.STACK, RareDropRedstone.TYPE, ChromiteChunk.RECIPE);
        new BastnaesiteChunk(plugin, Categories.SIMPLE_STORAGE_MATERIALS, BastnaesiteChunk.STACK, RareDropDiamond.TYPE, BastnaesiteChunk.RECIPE);
        new AntimonyChunk(plugin, Categories.SIMPLE_STORAGE_MATERIALS, AntimonyChunk.STACK, RareDropEmerald.TYPE, AntimonyChunk.RECIPE);

        new ChromiumDust(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiumDust.STACK, RecipeType.ORE_CRUSHER, ChromiumDust.RECIPE);
        new BastnaesiteDust(plugin, Categories.SIMPLE_STORAGE_MATERIALS, BastnaesiteDust.STACK, RecipeType.ORE_CRUSHER, BastnaesiteDust.RECIPE);
        new AntimonyDust(plugin, Categories.SIMPLE_STORAGE_MATERIALS, AntimonyDust.STACK, RecipeType.ORE_CRUSHER, AntimonyDust.RECIPE);

        new ChromiumIngot(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChromiumIngot.STACK, RecipeType.SMELTERY, ChromiumIngot.RECIPE);
        new BastnaesiteIngot(plugin, Categories.SIMPLE_STORAGE_MATERIALS, BastnaesiteIngot.STACK, RecipeType.SMELTERY, BastnaesiteIngot.RECIPE);
        new AntimonyIngot(plugin, Categories.SIMPLE_STORAGE_MATERIALS, AntimonyIngot.STACK, RecipeType.SMELTERY, AntimonyIngot.RECIPE);
        new Electrum(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Electrum.STACK, RecipeType.SMELTERY, Electrum.RECIPE);
        new Cupronickel(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Cupronickel.STACK, RecipeType.SMELTERY, Cupronickel.RECIPE);
        new Pewter(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Pewter.STACK, RecipeType.SMELTERY, Pewter.RECIPE);
        new Zamak1(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak1.STACK, RecipeType.SMELTERY, Zamak1.RECIPE);
        new Zamak2(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak2.STACK, RecipeType.SMELTERY, Zamak2.RECIPE);
        new Zamak3(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Zamak3.STACK, RecipeType.SMELTERY, Zamak3.RECIPE);
        new Nisil(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Nisil.STACK, RecipeType.SMELTERY, Nisil.RECIPE);
        new Nicrosil(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Nicrosil.STACK, RecipeType.SMELTERY, Nicrosil.RECIPE);

        new CupronickelReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, CupronickelReinforced.STACK, RecipeType.HEATED_PRESSURE_CHAMBER, CupronickelReinforced.RECIPE);
        new PewterReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, PewterReinforced.STACK, RecipeType.HEATED_PRESSURE_CHAMBER, PewterReinforced.RECIPE);

        new ElectrumPlate(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ElectrumPlate.STACK, MetalPressBasic.TYPE, ElectrumPlate.RECIPE);
        new CupronickelPlate(plugin, Categories.SIMPLE_STORAGE_MATERIALS, CupronickelPlate.STACK, MetalPressBasic.TYPE, CupronickelPlate.RECIPE);
        new PewterPlate(plugin, Categories.SIMPLE_STORAGE_MATERIALS, PewterPlate.STACK, MetalPressBasic.TYPE, PewterPlate.RECIPE);

        new DieBasic(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieBasic.STACK, DiePress.TYPE, DieBasic.RECIPE);
        new DieReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieReinforced.STACK, DiePress.TYPE, DieReinforced.RECIPE);
        new DieAdvanced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, DieAdvanced.STACK, DiePress.TYPE, DieAdvanced.RECIPE);

        new Thermocouple(plugin, Categories.SIMPLE_STORAGE_MATERIALS, Thermocouple.STACK, RecipeType.HEATED_PRESSURE_CHAMBER, Thermocouple.RECIPE);

        new ChestCoreBasic(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChestCoreBasic.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestCoreBasic.RECIPE);
        new ChestCoreReinforced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChestCoreReinforced.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestCoreReinforced.RECIPE);
        new ChestCoreAdvanced(plugin, Categories.SIMPLE_STORAGE_MATERIALS, ChestCoreAdvanced.STACK, RecipeType.ENHANCED_CRAFTING_TABLE, ChestCoreAdvanced.RECIPE);

    }

}
