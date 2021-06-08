package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.network.CombinedPlate;
import io.github.sefiraat.simplestorage.items.materials.network.CommunicationBlock;
import io.github.sefiraat.simplestorage.items.materials.network.DisplayPanel;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public final class ChestMaster extends MasterChest {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "BLOCK_CHEST_MASTER",
            Skulls.BLOCK_CHEST_MASTER,
            Messages.THEME_ITEM_MACHINE + "Chest Network Master",
            "",
            Messages.THEME_PASSIVE + "This block can access all Inventory",
            Messages.THEME_PASSIVE + "Cells within range.",
            "",
            Messages.THEME_PASSIVE + "Cells must be within 4 blocks.",
            Messages.THEME_PASSIVE + "of the master in any direction",
            Messages.THEME_PASSIVE + "except down.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Chest"
    );

    public static final ItemStack[] RECIPE = new ItemStack[] {
            CombinedPlate.STACK, DisplayPanel.STACK,        CombinedPlate.STACK,
            CombinedPlate.STACK, ChestDiamond.STACK,        CombinedPlate.STACK,
            CombinedPlate.STACK, CommunicationBlock.STACK,  CombinedPlate.STACK
    };

    public ChestMaster(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(plugin);
    }
}
