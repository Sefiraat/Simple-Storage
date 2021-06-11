package io.github.sefiraat.simplestorage.items.chests;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.SimpleStorageItemStacks;
import io.github.sefiraat.simplestorage.items.Skulls;
import io.github.sefiraat.simplestorage.items.chests.network.NetworkElement;
import io.github.sefiraat.simplestorage.items.chests.network.NetworkElement.NetworkElementType;
import io.github.sefiraat.simplestorage.items.chests.network.RemovalSet;
import io.github.sefiraat.simplestorage.runnables.RunnableHighlight;
import io.github.sefiraat.simplestorage.utils.Theme;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public final class NetworkInventoryCache extends AbstractCache {

    private int tick;
    private Map<Integer, NetworkElement> inventories = new HashMap<>();

    public NetworkInventoryCache(BlockMenu blockMenu) {
        super(blockMenu);
    }

    public void updateInventories() {
        inventories.clear();
        getInventories(blockMenu.getBlock(), SimpleStorage.inst().getManagerConfiguration().getVals().getNetworkRange());
        pages = (int) Math.ceil(inventories.size() / 45.0);
    }

    public void getInventories(Block block, int size) {
        int i = 0;
        for(int x = block.getLocation().getBlockX() - size; x <= block.getLocation().getBlockX() + size; x++) {
            for(int y = block.getLocation().getBlockY() - size; y <= block.getLocation().getBlockY() + size; y++) {
                for (int z = block.getLocation().getBlockZ() - size; z <= block.getLocation().getBlockZ() + size; z++) {
                    Block block2 = block.getLocation().getWorld().getBlockAt(x, y, z);
                    NetworkElement networkElement = getNetworkElement(block2);
                    if (networkElement != null) {
                        inventories.put(i, networkElement);
                        i++;
                    }
                }
            }
        }
    }

    @Nullable
    public NetworkElement getNetworkElement(Block block) {
        String s = BlockStorage.getLocationInfo(block.getLocation(), "id");
        if (s != null) {
            if (SimpleStorageItemStacks.INVENTORY_CELL.getItemId().equals(s)) { // Mine here - default regardless so who cares
                NetworkElement networkElement = new NetworkElement(block, 8, 7, 6);
                networkElement.setSkullTexture(Skulls.BLOCK_CELL_BASIC);
                networkElement.setType(NetworkElementType.INVENTORY_CELL);
                return networkElement;
            } else if (NetworkInventoryCache.ACCEPTED_BASIC_INFINITY.contains(s)) { // Infinity (No skulls)
                NetworkElement networkElement = new NetworkElement(block, 8, 1, 0);
                networkElement.setMaterial(block.getType());
                networkElement.setType(NetworkElementType.INFINITY_BARREL);
                String storedAmount = BlockStorage.getLocationInfo(block.getLocation(), "stored");
                if (storedAmount != null) {
                    networkElement.setBarrelAmount(Integer.parseInt(storedAmount));
                } else {
                    networkElement.setBarrelAmount(0);
                }
                return networkElement;
            }
        }
        return null;
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

            NetworkElement networkElement = inventories.get(listSlotNo);

            if (networkElement != null) {
                processCell(networkElement, slotNo, listSlotNo);
            } else {
                blockMenu.replaceExistingItem(slotNo, GuiItems.menuMasterDummy());
                blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> false);
            }
        }
    }

    private void processCell(@Nonnull NetworkElement networkElement, int slotNo, int listSlotNo) {

        Location location = networkElement.getBlock().getLocation();

        // Get cell name if stored
        String name = BlockStorage.getLocationInfo(location, "cellname");
        // Get cell material if stored
        Material material = null;
        if (BlockStorage.getLocationInfo(location, "cellmaterial") != null) {
            material = Material.valueOf(BlockStorage.getLocationInfo(location, "cellmaterial"));
        } else if (networkElement.getMaterial() != null) {
            material = networkElement.getMaterial();
        }
        // Set item and add handler
        blockMenu.replaceExistingItem(slotNo, GuiItems.menuCell(listSlotNo, name, material, networkElement));
        blockMenu.addMenuClickHandler(slotNo, (player, i1, itemStack1, clickAction) -> guiItemClick(networkElement, player, clickAction));

    }

    private boolean guiItemClick(@Nonnull NetworkElement networkElement, Player player, @Nonnull ClickAction clickAction) {
        Block block = networkElement.getBlock();
        if (clickAction.isRightClicked()) {
            new RunnableHighlight(block.getLocation().clone().add(0.5, 0.5, 0.5)).runTaskTimer(SimpleStorage.inst(), 0, 40L);
            player.closeInventory();
            return false;
        } else {
            return guiItemLeftClick(networkElement, player);
        }
    }

    private boolean guiItemLeftClick(@Nonnull NetworkElement networkElement, Player player) {

        Block block = networkElement.getBlock();

        BlockMenu blockMenu = BlockStorage.getInventory(block);
        RemovalSet removalSet = new RemovalSet(
                blockMenu.getItemInSlot(networkElement.getSlotClose()),
                blockMenu.getMenuClickHandler(networkElement.getSlotClose()),
                blockMenu.getItemInSlot(networkElement.getSlotRename()),
                blockMenu.getMenuClickHandler(networkElement.getSlotRename()),
                blockMenu.getItemInSlot(networkElement.getSlotSetBlock()),
                blockMenu.getMenuClickHandler(networkElement.getSlotRename())
        );

        // Add Close item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simpleclose", "y");
        blockMenu.replaceExistingItem(networkElement.getSlotClose(), GuiItems.menuClose());
        blockMenu.addMenuClickHandler(networkElement.getSlotClose(), (player2, i2, itemStack2, clickAction2) -> guiClose(player2, blockMenu, networkElement, removalSet, true));

        // Add Rename item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simplerename", "y");
        blockMenu.replaceExistingItem(networkElement.getSlotRename(), GuiItems.menuRenameCell());
        blockMenu.addMenuClickHandler(networkElement.getSlotRename(), (player2, i2, itemStack2, clickAction2) -> guiRename(block, player2));

        // Add SetMaterial item to drilled down inventory - set block storage to show items added (for removing later)
        BlockStorage.addBlockInfo(block, "simplesetblock", "y");
        blockMenu.replaceExistingItem(networkElement.getSlotSetBlock(), GuiItems.menuSetMaterial());
        blockMenu.addMenuClickHandler(networkElement.getSlotSetBlock(), (player2, i2, itemStack2, clickAction2) -> guiSetMaterial(block, player2));

        blockMenu.addMenuCloseHandler(player1 -> guiClose(player1, blockMenu, networkElement, removalSet,false));

        blockMenu.open(player);
        return false;

    }

    private boolean guiClose(Player player, @Nonnull BlockMenu invMenu, @Nonnull NetworkElement networkElement, @Nonnull RemovalSet removalSet, boolean back) {
        // Go back to main menu, set flags to N for removal
        invMenu.replaceExistingItem(networkElement.getSlotClose(), removalSet.getOriginalGuiClose());
        invMenu.addMenuClickHandler(networkElement.getSlotClose(), removalSet.getCloseMenuClickHandler());
        invMenu.replaceExistingItem(networkElement.getSlotRename(), removalSet.getOriginalGuiRename());
        invMenu.addMenuClickHandler(networkElement.getSlotRename(), removalSet.getRenameMenuClickHandler());
        invMenu.replaceExistingItem(networkElement.getSlotSetBlock(), removalSet.getOriginalGuiBlock());
        invMenu.addMenuClickHandler(networkElement.getSlotSetBlock(), removalSet.getBlockMenuClickHandler());
        if (back) {
            BlockMenu blockMenu = this.blockMenu;
            blockMenu.open(player);
        }
        return false;
    }

    private boolean guiRename(Block block, @Nonnull Player player) {
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

    private boolean guiSetMaterial(Block block, @Nonnull Player player) {
        Material m = player.getItemOnCursor().getType();
        if (m != Material.AIR) {
            BlockStorage.addBlockInfo(block, "cellmaterial", m.toString());
            player.sendMessage(Theme.SUCCESS + "Icon material set");
        } else {
            player.sendMessage(Theme.ERROR + "You must have an item on your cursor");
        }
        return false;
    }

    public static final List<String> ACCEPTED_BASIC_INFINITY = new ArrayList<>(Arrays.asList(
            "BASIC_STORAGE",
            "ADVANCED_STORAGE",
            "REINFORCED_STORAGE",
            "VOID_STORAGE",
            "INFINITY_STORAGE"
    ));

    public static final List<String> ACCEPTED_SKULL_INFINITY = new ArrayList<>(Collections.emptyList());


}
