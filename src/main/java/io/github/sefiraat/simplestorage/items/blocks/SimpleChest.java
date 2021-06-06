package io.github.sefiraat.simplestorage.items.blocks;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.simplestorage.configuration.ManagerConfiguration;
import io.github.sefiraat.simplestorage.statics.CustomItems;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
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

public class SimpleChest extends AbstractContainer {

    static final int SLOT_INFO = 0;
    static final int SLOT_INPUT = 4;
    static final int SLOT_FORWARD = 6;
    static final int SLOT_BACK = 2;
    static final int[] BACKGROUND_SLOTS = {1, 2, 3, 5, 6, 7, 8};

    private final Map<Location, InventoryCache> inventoryCaches = new HashMap<>();

    private final int pages;

    public SimpleChest(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int pages) {
        super(category, item, recipeType, recipe);

        this.pages = pages;

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return true;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config data) {
                InventoryCache inventoryCache = SimpleChest.this.inventoryCaches.get(block.getLocation());
                if (inventoryCache != null) {
                    inventoryCache.process(block);
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
        if (itemTransportFlow == ItemTransportFlow.INSERT) {
            return new int[] {SLOT_INPUT};
        }
        return new int[0];
    }

    @Override
    protected void onBreak(@NotNull BlockBreakEvent event, @NotNull BlockMenu blockMenu, @NotNull Location location) {
        super.onBreak(event, blockMenu, location);
        InventoryCache inventoryCache = inventoryCaches.remove(location);
        if (inventoryCache != null) {
            inventoryCache.kill(location);
        }
    }

    @Override
    protected void onNewInstance(@NotNull BlockMenu menu, @NotNull Block b) {
        super.onNewInstance(menu, b);
        String foundID = BlockStorage.getLocationInfo(b.getLocation(),"simple-chest-id");
        if (foundID != null) {
            inventoryCaches.put(b.getLocation(), new InventoryCache(this, menu, pages, Integer.parseInt(foundID)));
        } else {
            int chestID = ManagerConfiguration.getNextChestID();
            BlockStorage.addBlockInfo(b, "simple-chest-id", String.valueOf(chestID));
            ManagerConfiguration.setupChest(chestID);
            inventoryCaches.put(b.getLocation(), new InventoryCache(this, menu, pages, chestID));
        }
    }

    @Override
    protected void onPlace(@NotNull BlockPlaceEvent e, @NotNull Block b) {
        super.onPlace(e, b);
    }

}
