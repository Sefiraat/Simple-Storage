package io.github.sefiraat.simplestorage.items.blocks;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.simplestorage.statics.CustomItems;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MasterChest extends AbstractContainer {

    static final int SLOT_INFO = 0;
    static final int SLOT_BACK = 1;
    static final int SLOT_FORWARD = 2;
    static final int[] BACKGROUND_SLOTS = {3, 4, 5, 6, 7, 8};

    private final Map<Location, MasterInventoryCache> inventoryCaches = new HashMap<>();

    public MasterChest(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return true;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config data) {
                MasterInventoryCache masterInventoryCache = MasterChest.this.inventoryCaches.get(block.getLocation());
                if (masterInventoryCache != null) {
                    masterInventoryCache.process();
                }
            }
        });
    }

    @Override
    protected void setupMenu(@NotNull BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.setSize(54);
        blockMenuPreset.drawBackground(CustomItems.menuBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.addItem(SLOT_BACK, CustomItems.menuChestPageBack());
        blockMenuPreset.addItem(SLOT_FORWARD, CustomItems.menuChestPageForward());
        blockMenuPreset.addItem(SLOT_INFO, CustomItems.menuInfo());
    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    protected void onBreak(@NotNull BlockBreakEvent event, @NotNull BlockMenu blockMenu, @NotNull Location location) {
        super.onBreak(event, blockMenu, location);
        MasterInventoryCache masterInventoryCache = inventoryCaches.remove(location);
        if (masterInventoryCache != null) {
            masterInventoryCache.kill(location);
        }
    }

    @Override
    protected void onNewInstance(@NotNull BlockMenu menu, @NotNull Block b) {
        super.onNewInstance(menu, b);
        inventoryCaches.put(b.getLocation(), new MasterInventoryCache(this, menu));
    }

    @Override
    protected void onPlace(@NotNull BlockPlaceEvent e, @NotNull Block b) {
        super.onPlace(e, b);
    }

}
