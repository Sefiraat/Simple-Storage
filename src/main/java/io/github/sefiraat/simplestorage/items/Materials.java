package io.github.sefiraat.simplestorage.items;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.machines.DiePress;
import io.github.sefiraat.simplestorage.items.machines.MetalPressBasic;
import io.github.sefiraat.simplestorage.items.materials.GemAngelite;
import io.github.sefiraat.simplestorage.items.materials.GemProustite;
import io.github.sefiraat.simplestorage.items.materials.GemQuartz;
import io.github.sefiraat.simplestorage.items.materials.GemShortite;
import io.github.sefiraat.simplestorage.items.other.RareDropQuartz;
import io.github.sefiraat.simplestorage.items.other.RareDropLapis;
import io.github.sefiraat.simplestorage.items.other.RareDropRedstone;
import io.github.sefiraat.simplestorage.items.other.RareDropCoal;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.inventory.ItemStack;

public final class Materials {

    private Materials() {
        throw new IllegalStateException("Utility class");
    }

    public static void set(SimpleStorage p) {

        new GemAngelite(p, Categories.MAT, SlimefunItemStacks.ANGELITE, RecipeType.GEO_MINER, new ItemStack[9]);
        new GemProustite(p, Categories.MAT, SlimefunItemStacks.PROUSTITE, RecipeType.GEO_MINER, new ItemStack[9]);
        new GemShortite(p, Categories.MAT, SlimefunItemStacks.SHORTITE, RecipeType.GEO_MINER, new ItemStack[9]);
        new GemQuartz(p, Categories.MAT, SlimefunItemStacks.CLEARQUARTZ, RecipeType.GEO_MINER, new ItemStack[9]);

        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.CHUNK_CHROMITE, RareDropCoal.TYPE, new ItemStack[9]).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.CHUNK_BASTNAESITE, RareDropQuartz.TYPE, new ItemStack[9]).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.CHUNK_ANTIMONY, RareDropLapis.TYPE, new ItemStack[9]).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.RHENIUM_CHUNK, RareDropRedstone.TYPE, new ItemStack[9]).register(p);

        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CHROMIUM_DUST, RecipeType.ORE_CRUSHER, SlimefunItemRecipes.CHROMIUM_DUST).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.BASTNAESITE_DUST, RecipeType.ORE_CRUSHER, SlimefunItemRecipes.BASTNAESITE_DUST).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ANTIMONY_DUST, RecipeType.ORE_CRUSHER, SlimefunItemRecipes.ANTIMONY_DUST).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.RHENIUM_DUST, RecipeType.ORE_CRUSHER, SlimefunItemRecipes.RHENIUM_DUST).register(p);

        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CHROMIUM_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.CHROMIUM_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.BASTNAESITE_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.BASTNAESITE_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ANTIMONY_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.ANTIMONY_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.RHENIUM_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.RHENIUM_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ELECTRUM_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.ELECTRUM_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CUPRONICKEL_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.CUPRONICKEL_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.PEWTER_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.PEWTER_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.NICKEL_SUPER_INGOT, RecipeType.SMELTERY, SlimefunItemRecipes.NICKEL_SUPERALLOY_INGOT).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ZAMAK_1, RecipeType.SMELTERY, SlimefunItemRecipes.ZAMAK_1).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ZAMAK_2, RecipeType.SMELTERY, SlimefunItemRecipes.ZAMAK_2).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.ZAMAK_3, RecipeType.SMELTERY, SlimefunItemRecipes.ZAMAK_3).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.NISIL, RecipeType.SMELTERY, SlimefunItemRecipes.NISIL).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.NICROSIL, RecipeType.SMELTERY, SlimefunItemRecipes.NICROSIL).register(p);

        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CUPRONICKEL_REINFORCED, RecipeType.HEATED_PRESSURE_CHAMBER, SlimefunItemRecipes.CUPRONICKEL_REINFORCED).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.PEWTER_REINFORCED, RecipeType.HEATED_PRESSURE_CHAMBER, SlimefunItemRecipes.PEWTER_REINFORCED).register(p);

        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.ELECTRUM_PLATE, MetalPressBasic.TYPE, SlimefunItemRecipes.ELECTRUM_PLATE).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.CUPRONICKEL_PLATE, MetalPressBasic.TYPE, SlimefunItemRecipes.CUPRONICKEL_PLATE).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.PEWTER_PLATE, MetalPressBasic.TYPE, SlimefunItemRecipes.PEWTER_PLATE).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.NICKEL_SUPERALLOY_PLATE, MetalPressBasic.TYPE, SlimefunItemRecipes.NICKEL_SUPERALLOY_PLATE).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.COMBINED_PLATE, RecipeType.HEATED_PRESSURE_CHAMBER, SlimefunItemRecipes.COMBINED_PLATE).register(p);

        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.DIE_BASIC, DiePress.TYPE, SlimefunItemRecipes.DIE_BASIC).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.DIE_REINFORCED, DiePress.TYPE, SlimefunItemRecipes.DIE_REINFORCED).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.DIE_ADVANCED, DiePress.TYPE, SlimefunItemRecipes.DIE_ADVANCED).register(p);

        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.THERMOCOUPLE, RecipeType.HEATED_PRESSURE_CHAMBER, SlimefunItemRecipes.THERMOCOUPLE).register(p);

        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CHEST_CORE_BASIC, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_CORE_BASIC).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CHEST_CORE_REINFORCED, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_CORE_REINFORCED).register(p);
        new SlimefunItem(Categories.MAT, SlimefunItemStacks.CHEST_CORE_ADVANCED, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.CHEST_CORE_ADVANCED).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.COMMUNICATION_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.COMMUNICATION_BLOCK).register(p);
        new UnplaceableBlock(Categories.MAT, SlimefunItemStacks.DISPLAY_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItemRecipes.DISPLAY_PANEL).register(p);

        AContainer heatedPressureChamber = (AContainer) SlimefunItems.HEATED_PRESSURE_CHAMBER.getItem();
        heatedPressureChamber.registerRecipe(60, new ItemStack[]{SlimefunItemStacks.CUPRONICKEL_INGOT, SlimefunItemStacks.BASTNAESITE_INGOT}, new ItemStack[]{SlimefunItemStacks.CUPRONICKEL_REINFORCED});
        heatedPressureChamber.registerRecipe(100, new ItemStack[]{SlimefunItemStacks.PEWTER_INGOT, SlimefunItemStacks.ANTIMONY_INGOT}, new ItemStack[]{SlimefunItemStacks.PEWTER_REINFORCED});
        heatedPressureChamber.registerRecipe(150, new ItemStack[]{SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.NICKEL_SUPERALLOY_PLATE}, new ItemStack[]{SlimefunItemStacks.COMBINED_PLATE});
        heatedPressureChamber.registerRecipe(30, new ItemStack[]{SlimefunItemStacks.NISIL, SlimefunItemStacks.NICROSIL}, new ItemStack[]{SlimefunItemStacks.THERMOCOUPLE});

        AContainer heatedPressureChamber2 = (AContainer) SlimefunItems.HEATED_PRESSURE_CHAMBER_2.getItem();
        heatedPressureChamber2.registerRecipe(60, new ItemStack[]{SlimefunItemStacks.CUPRONICKEL_INGOT, SlimefunItemStacks.BASTNAESITE_INGOT}, new ItemStack[]{SlimefunItemStacks.CUPRONICKEL_REINFORCED});
        heatedPressureChamber2.registerRecipe(100, new ItemStack[]{SlimefunItemStacks.PEWTER_INGOT, SlimefunItemStacks.ANTIMONY_INGOT}, new ItemStack[]{SlimefunItemStacks.PEWTER_REINFORCED});
        heatedPressureChamber2.registerRecipe(150, new ItemStack[]{SlimefunItemStacks.PEWTER_PLATE, SlimefunItemStacks.NICKEL_SUPERALLOY_PLATE}, new ItemStack[]{SlimefunItemStacks.COMBINED_PLATE});
        heatedPressureChamber2.registerRecipe(30, new ItemStack[]{SlimefunItemStacks.NISIL, SlimefunItemStacks.NICROSIL}, new ItemStack[]{SlimefunItemStacks.THERMOCOUPLE});

    }

}
