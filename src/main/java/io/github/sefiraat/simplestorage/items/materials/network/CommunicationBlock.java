package io.github.sefiraat.simplestorage.items.materials.network;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.iron.ChestCoreBasic;
import io.github.sefiraat.simplestorage.items.materials.iron.ElectrumPlate;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CommunicationBlock extends UnplaceableBlock implements NotPlaceable {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_COMMUNICATION",
            Material.BLACK_GLAZED_TERRACOTTA,
            Messages.THEME_ITEM_MACHINE + "Communication Block",
            "",
            Messages.THEME_PASSIVE + "Allows the networking of various",
            Messages.THEME_PASSIVE + "inventories to the Master.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            ElectrumPlate.STACK,    SlimefunItems.GOLD_24K_BLOCK,     ElectrumPlate.STACK,
            SlimefunItems.GOLD_24K, ChestCoreBasic.STACK,             SlimefunItems.GOLD_24K,
            ElectrumPlate.STACK,    new ItemStack(Material.REPEATER), ElectrumPlate.STACK
    };

    public CommunicationBlock(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }
}
