package io.github.sefiraat.simplestorage.items.blocks;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.configuration.ManagerConfiguration;
import io.github.sefiraat.simplestorage.statics.CustomItems;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static io.github.sefiraat.simplestorage.items.blocks.SimpleChest.SLOT_INPUT;

public final class InventoryCache {

    private final SimpleChest chest;
    private final BlockMenu blockMenu;
    private final int pages;
    private final int chestID;

    private int page = 1;

    private Map<Integer, String> guiNumbers = new HashMap<>();
    private Map<Integer, ItemStack> items = new HashMap<>();

    public InventoryCache(SimpleChest simpleChest, BlockMenu blockMenu, int pages, int chestID) {
        this.chest = simpleChest;
        this.blockMenu = blockMenu;
        this.pages = pages;
        this.chestID = chestID;

        setupGuiNumbers();

        blockMenu.addMenuClickHandler(SimpleChest.SLOT_BACK, (player, i, itemStack, clickAction) -> {
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

        blockMenu.addMenuClickHandler(SimpleChest.SLOT_FORWARD, (player, i, itemStack, clickAction) -> {
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
        items.clear();
        ConfigurationSection section = SimpleStorage.getInstance().getManagerConfiguration().getChestConfig().getConfigurationSection("CHESTS." + chestID);
        for (int i = 1; i <= (pages * 45); i++) {
            ItemStack itemStack = section.getItemStack("SLOT-" + i);
            if (itemStack != null) {
            } else {

            }
            items.put(i, itemStack);
        }
    }

    public void input() {
        ItemStack input = blockMenu.getItemInSlot(SLOT_INPUT);
        if (input == null) {

            return;
        }
        // Check matching first
        for (Map.Entry<Integer, ItemStack> entry : items.entrySet()) {
            if (entry.getValue() != null) {
                if (inputOverSaved(entry, input)) {
                    return;
                }
            }
        }
        // Then slot into next free slot, if available
        for (Map.Entry<Integer, ItemStack> entry : items.entrySet()) {
            if (entry.getValue() == null) {
                ManagerConfiguration.setChestSlotItem(chestID, entry.getKey(), input.clone());
                input.setAmount(0);
                return;
            }
        }
        // Item doesn't fit
    }

    public boolean inputOverSaved(Map.Entry<Integer, ItemStack> entry, ItemStack input) {
        ItemStack saveStack = entry.getValue();
        int saveSlot = entry.getKey();
        if (entry.getValue().isSimilar(input) && entry.getValue().getAmount() < entry.getValue().getMaxStackSize()) {
            int amountFit = entry.getValue().getMaxStackSize() - entry.getValue().getAmount();
            if (amountFit > input.getAmount()) {
                saveStack.setAmount(saveStack.getAmount() + input.clone().getAmount());
                input.setAmount(0);
            } else {
                saveStack.setAmount(saveStack.getMaxStackSize());
                input.setAmount(input.getAmount() - amountFit);
            }
            ManagerConfiguration.setChestSlotItem(chestID, saveSlot, saveStack);
            return true;
        }
        return false;
    }

    public void updateView() {
        if (blockMenu.hasViewer()) {
            for (int i = 0; i < 45 ; i++) {
                int slotNo = i + 9;
                int listSlotNo = ((page - 1) * 45) + (i + 1);
                ItemStack itemStack = items.get(listSlotNo);
                if (itemStack == null) {
                    blockMenu.replaceExistingItem(slotNo, CustomItems.menuChestDummy());
                    blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> false);
                } else {
                    blockMenu.replaceExistingItem(slotNo, itemStack);
                    blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> {
                        if (!clickAction.isRightClicked()) {
                            if (player.getItemOnCursor().getType() == Material.AIR) {
                                player.setItemOnCursor(itemStack.clone());
                                blockMenu.replaceExistingItem(slotNo, CustomItems.menuChestDummy());
                                blockMenu.addMenuClickHandler(slotNo, (player2, i2, itemStack2, clickAction2) -> false);
                                ManagerConfiguration.setChestSlotItem(chestID, listSlotNo, null);
                                return false;
                            }
                        }
                        return false;
                    });
                }
            }
        }
    }

    public void process(Block block) {
        updateItems();
        input();
        updateView();
    }

    public void kill(Location location) {
        dropItems(location);
        ManagerConfiguration.removeChestID(chestID);
        BlockStorage.clearBlockInfo(location);
    }

    public void dropItems(Location location) {
        ConfigurationSection section = SimpleStorage.getInstance().getManagerConfiguration().getChestConfig().getConfigurationSection("CHESTS." + chestID);
        for (String s : section.getKeys(false)) {
            if (!s.equals("PLACED")) {
                ItemStack itemStack = section.getItemStack(s);
                if (itemStack != null) {
                    location.getWorld().dropItemNaturally(location,itemStack);
                }
            }
        }
        if (blockMenu.getItemInSlot(SLOT_INPUT) != null) {
            location.getWorld().dropItemNaturally(location, blockMenu.getItemInSlot(SLOT_INPUT).clone());
        }
    }


}
