package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.CustomItems;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

public final class MasterInventoryCache {

    private final MasterChest chest;
    private final BlockMenu blockMenu;

    private int pages;
    private int page = 1;

    private Map<Integer, String> guiNumbers = new HashMap<>();
    private Map<Integer, Block> cells = new HashMap<>();

    public MasterInventoryCache(MasterChest masterChest, BlockMenu blockMenu) {
        this.chest = masterChest;
        this.blockMenu = blockMenu;

        setupGuiNumbers();

        blockMenu.addMenuClickHandler(MasterChest.SLOT_BACK, (player, i, itemStack, clickAction) -> {
            if (page > 1) {
                page-= 1;
            }
            int skullID = page;
            if (page > 20) {
                skullID = 21;
            }
            blockMenu.replaceExistingItem(0, new CustomItem(
                    SkullItem.fromBase64(guiNumbers.get(skullID)),
                    Messages.THEME_GUI_HEAD + "Info",
                    "",
                    Messages.THEME_CLICK_INFO + "Page number : " + page
            ));
            return false;
        });

        blockMenu.addMenuClickHandler(MasterChest.SLOT_FORWARD, (player, i, itemStack, clickAction) -> {
            if (page < pages) {
                page+= 1;
            }
            int skullID = page;
            if (page > 20) {
                skullID = 21;
            }
            blockMenu.replaceExistingItem(0, new CustomItem(
                    SkullItem.fromBase64(guiNumbers.get(skullID)),
                    Messages.THEME_GUI_HEAD + "Info",
                    "",
                    Messages.THEME_CLICK_INFO + "Page number : " + page
            ));
            return false;
        });

    }

    private void setupGuiNumbers() {
        guiNumbers.put(1, Skulls.GUI_NO1);
        guiNumbers.put(2, Skulls.GUI_NO2);
        guiNumbers.put(3, Skulls.GUI_NO3);
        guiNumbers.put(4, Skulls.GUI_NO4);
        guiNumbers.put(5, Skulls.GUI_NO5);
        guiNumbers.put(6, Skulls.GUI_NO6);
        guiNumbers.put(7, Skulls.GUI_NO7);
        guiNumbers.put(8, Skulls.GUI_NO8);
        guiNumbers.put(9, Skulls.GUI_NO9);
        guiNumbers.put(10, Skulls.GUI_NO10);
        guiNumbers.put(11, Skulls.GUI_NO11);
        guiNumbers.put(12, Skulls.GUI_NO12);
        guiNumbers.put(13, Skulls.GUI_NO13);
        guiNumbers.put(14, Skulls.GUI_NO14);
        guiNumbers.put(15, Skulls.GUI_NO15);
        guiNumbers.put(16, Skulls.GUI_NO16);
        guiNumbers.put(17, Skulls.GUI_NO17);
        guiNumbers.put(18, Skulls.GUI_NO18);
        guiNumbers.put(19, Skulls.GUI_NO19);
        guiNumbers.put(20, Skulls.GUI_NO20);
        guiNumbers.put(21, Skulls.GUI_NOPLUS);
    }

    public void updateItems() {
        cells.clear();
        getBlocks(blockMenu.getBlock(),4);
        pages = (int) Math.ceil(cells.size() / 45.0);
    }

    public void getBlocks(Block block, int size) {
        int i = 0;
        for(int x = block.getLocation().getBlockX() - size; x <= block.getLocation().getBlockX() + size; x++) {
            for(int y = block.getLocation().getBlockY(); y <= block.getLocation().getBlockY() + size; y++) {
                for (int z = block.getLocation().getBlockZ() - size; z <= block.getLocation().getBlockZ() + size; z++) {
                    Block block2 = block.getLocation().getWorld().getBlockAt(x, y, z);
                    if (isCell(block2)) {
                        cells.put(i, block2);
                        i++;
                    }
                }
            }
        }
    }

    public boolean isCell(Block b) {
        String s = BlockStorage.getLocationInfo(b.getLocation(), "id");
        return s != null && s.equals("BLOCK_CELL_BASIC");
    }

    public void updateView() {
        if (blockMenu.hasViewer()) {
            for (int i = 0; i < 45 ; i++) {
                int slotNo = i + 9;
                int listSlotNo = ((page - 1) * 45) + i;

                Block block = cells.get(listSlotNo);

                if (block != null) {
                    // Get cell name if stored
                    String name = BlockStorage.getLocationInfo(block.getLocation(),"cellname");
                    // Get cell material if stored
                    Material material = null;
                    if (BlockStorage.getLocationInfo(block.getLocation(), "cellmaterial") != null) {
                        material = Material.valueOf(BlockStorage.getLocationInfo(block.getLocation(), "cellmaterial"));
                    }
                    // Set item and add handler
                    blockMenu.replaceExistingItem(slotNo, CustomItems.menuCell(listSlotNo, name, material));
                    blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> {

                        BlockMenu blockMenu = BlockStorage.getInventory(block);

                        // region CLOSE
                        // Add Close item to drilled down inventory - set block storage to show items added (for removing later)
                        BlockStorage.addBlockInfo(block, "simpleclose", "y");
                        blockMenu.replaceExistingItem(8, CustomItems.menuClose());
                        blockMenu.addMenuClickHandler(8, (player2, i2, itemStack2, clickAction2) -> {
                            // Go back to main menu, set flags to N for removal
                            BlockMenu blockMenu1 = this.blockMenu;
                            blockMenu1.open(player);
                            BlockStorage.addBlockInfo(block, "simplesetblock", "n");
                            BlockStorage.addBlockInfo(block, "simpleclose", "n");
                            BlockStorage.addBlockInfo(block, "simplerename", "n");
                            return false;
                        });
                        // endregion

                        // region RENAME
                        // Add Rename item to drilled down inventory - set block storage to show items added (for removing later)
                        BlockStorage.addBlockInfo(block, "simplerename", "y");
                        blockMenu.replaceExistingItem(7, CustomItems.menuRenameCell());
                        blockMenu.addMenuClickHandler(7, (player2, i2, itemStack2, clickAction2) -> {
                            // Prepare for item name in chat, flag rename item for removal
                            player2.closeInventory();
                            player2.sendMessage("Enter new name for this inventory cell - supports colors codes!");
                            ChatUtils.awaitInput(player2, message -> {
                                BlockStorage.addBlockInfo(block,"cellname",message);
                                blockMenu.open(player);
                                BlockStorage.addBlockInfo(block, "simplerename", "n");
                            });
                            return false;
                        });
                        // endregion

                        // region SETMATERIAL
                        // Add SetMaterial item to drilled down inventory - set block storage to show items added (for removing later)
                        BlockStorage.addBlockInfo(block, "simplesetblock", "y");
                        blockMenu.replaceExistingItem(6, CustomItems.menuSetMaterial());
                        blockMenu.addMenuClickHandler(6, (player2, i2, itemStack2, clickAction2) -> {
                            Material m = player2.getItemOnCursor().getType();
                            if (m != Material.AIR) {
                                BlockStorage.addBlockInfo(block, "cellmaterial", m.toString());
                            }
                            return false;
                        });
                        // endregion


                        blockMenu.addMenuCloseHandler(player1 -> {
                            // Close inventory, set flags to N for removal
                            BlockStorage.addBlockInfo(block, "simplesetblock", "n");
                            BlockStorage.addBlockInfo(block, "simpleclose", "n");
                            BlockStorage.addBlockInfo(block, "simplerename", "n");
                        });



                        blockMenu.open(player);
                        return false;




                    });
                } else {
                    blockMenu.replaceExistingItem(slotNo, CustomItems.menuMasterDummy());
                    blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> false);
                }
            }
        }
    }

    public void process() {
        updateItems();
        updateView();
    }

    public void kill(Location location) {
        BlockStorage.clearBlockInfo(location);
    }

}
