package io.github.sefiraat.simplestorage.items.chests;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.SlimefunItemStacks;
import io.github.sefiraat.simplestorage.statics.GuiItems;
import io.github.sefiraat.simplestorage.statics.Theme;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class NetworkInventoryCache extends AbstractCache {

    private int tick;
    private Map<Integer, Block> inventories = new HashMap<>();

    public NetworkInventoryCache(BlockMenu blockMenu) {
        super(blockMenu);
    }

    public void updateInventories() {
        if (validTick()) {
            inventories.clear();
            getInventories(blockMenu.getBlock(), SimpleStorage.inst().getManagerConfiguration().getVals().getNetworkRange());
            pages = (int) Math.ceil(inventories.size() / 45.0);
        }
    }

    public void getInventories(Block block, int size) {
        int i = 0;
        for(int x = block.getLocation().getBlockX() - size; x <= block.getLocation().getBlockX() + size; x++) {
            for(int y = block.getLocation().getBlockY() - size; y <= block.getLocation().getBlockY() + size; y++) {
                for (int z = block.getLocation().getBlockZ() - size; z <= block.getLocation().getBlockZ() + size; z++) {
                    Block block2 = block.getLocation().getWorld().getBlockAt(x, y, z);
                    if (isCell(block2)) {
                        inventories.put(i, block2);
                        i++;
                    }
                }
            }
        }
    }

    public boolean isCell(Block b) {
        String s = BlockStorage.getLocationInfo(b.getLocation(), "id");
        return s != null && s.equals(SlimefunItemStacks.INVENTORY_CELL.getItemId());
    }

    private boolean validTick() {
        if (tick >= SimpleStorage.inst().getManagerConfiguration().getVals().getNetworkTickRate()) {
            tick = 1;
            return true;
        } else {
            tick++;
            return false;
        }
    }

    public void process() {
        if (blockMenu.hasViewer()) {
            updateInventories();
            updateView();
        }
    }

    public void kill(Location location) {
        BlockStorage.clearBlockInfo(location);
    }

    public void updateView() {
        for (int i = 0; i < 45; i++) {
            int slotNo = i + 9;
            int listSlotNo = ((page - 1) * 45) + i;

            Block block = inventories.get(listSlotNo);

            if (block != null) {
                processCell(block, slotNo, listSlotNo);
            } else {
                blockMenu.replaceExistingItem(slotNo, GuiItems.menuMasterDummy());
                blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> false);
            }
        }
    }

    private void processCell(Block block, int slotNo, int listSlotNo) {

        // Get cell name if stored
        String name = BlockStorage.getLocationInfo(block.getLocation(), "cellname");
        // Get cell material if stored
        Material material = null;
        if (BlockStorage.getLocationInfo(block.getLocation(), "cellmaterial") != null) {
            material = Material.valueOf(BlockStorage.getLocationInfo(block.getLocation(), "cellmaterial"));
        }
        // Set item and add handler
        blockMenu.replaceExistingItem(slotNo, GuiItems.menuCell(listSlotNo, name, material));
        blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> guiItemClick(block, player));

    }

    private boolean guiItemClick(Block block, Player player) {

        BlockMenu blockMenu = BlockStorage.getInventory(block);

        // Add Close item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simpleclose", "y");
        blockMenu.replaceExistingItem(8, GuiItems.menuClose());
        blockMenu.addMenuClickHandler(8, (player2, i2, itemStack2, clickAction2) -> guiSetClose(block, player2));

        // Add Rename item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simplerename", "y");
        blockMenu.replaceExistingItem(7, GuiItems.menuRenameCell());
        blockMenu.addMenuClickHandler(7, (player2, i2, itemStack2, clickAction2) -> guiSetRename(block, player2));

        // Add SetMaterial item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simplesetblock", "y");
        blockMenu.replaceExistingItem(6, GuiItems.menuSetMaterial());
        blockMenu.addMenuClickHandler(6, (player2, i2, itemStack2, clickAction2) -> guiSetSetMaterial(block, player2));

        blockMenu.addMenuCloseHandler(player1 -> {
            // Close inventory, set flags to N for removal
            BlockStorage.addBlockInfo(block, "simplesetblock", "n");
            BlockStorage.addBlockInfo(block, "simpleclose", "n");
            BlockStorage.addBlockInfo(block, "simplerename", "n");
        });

        blockMenu.open(player);
        return false;

    }

    private boolean guiSetClose(Block block, Player player) {
        // Go back to main menu, set flags to N for removal
        BlockMenu blockMenu1 = this.blockMenu;
        blockMenu1.open(player);
        BlockStorage.addBlockInfo(block, "simplesetblock", "n");
        BlockStorage.addBlockInfo(block, "simpleclose", "n");
        BlockStorage.addBlockInfo(block, "simplerename", "n");
        return false;
    }

    private boolean guiSetRename(Block block, Player player) {
        // Prepare for item name in chat, flag rename item for removal
        player.closeInventory();
        player.sendMessage(Theme.WARNING + "Enter a new name for this inventory cell, supports colour codes");
        ChatUtils.awaitInput(player, message -> {
            BlockStorage.addBlockInfo(block, "cellname", message);
            BlockStorage.addBlockInfo(block, "simplerename", "n");
            player.sendMessage(Theme.SUCCESS + "Cell name updated");
        });
        return false;
    }

    private boolean guiSetSetMaterial(Block block, Player player) {
        Material m = player.getItemOnCursor().getType();
        if (m != Material.AIR) {
            BlockStorage.addBlockInfo(block, "cellmaterial", m.toString());
            player.sendMessage(Theme.SUCCESS + "Icon material set");
        } else {
            player.sendMessage(Theme.ERROR + "You must have an item on your cursor");
        }
        return false;
    }

}
