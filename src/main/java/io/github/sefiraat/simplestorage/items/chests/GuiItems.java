package io.github.sefiraat.simplestorage.items.chests;

import io.github.sefiraat.simplestorage.items.Skulls;
import io.github.sefiraat.simplestorage.items.chests.network.NetworkElement;
import io.github.sefiraat.simplestorage.items.chests.network.NetworkElement.NetworkElementType;
import io.github.sefiraat.simplestorage.utils.Theme;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public final class GuiItems {

    private GuiItems() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem menuBackground() {
        return new CustomItem(
                Material.GRAY_STAINED_GLASS_PANE,
                Theme.PASSIVE + "Simple!",
                ""
        );
    }

    public static CustomItem menuInfo() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_NO1),
                Theme.GUI_HEAD + "Info",
                "",
                "Page number : 1"
        );
    }

    public static CustomItem menuChestPageBack() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_BACK),
                Theme.GUI_HEAD + "Back",
                "",
                Theme.CLICK_INFO + "Click to navigate back a page."
        );
    }

    public static CustomItem menuChestPageForward() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_FORWARD),
                Theme.GUI_HEAD + "Forward",
                "",
                Theme.CLICK_INFO + "Click to navigate forward a page."
        );
    }

    public static CustomItem menuChestDummy() {
        return new CustomItem(
                Material.LIGHT_GRAY_STAINED_GLASS_PANE,
                Theme.PASSIVE + "No item here"
        );
    }

    public static CustomItem menuMasterDummy() {
        return new CustomItem(
                Material.LIGHT_GRAY_STAINED_GLASS_PANE,
                Theme.PASSIVE + "No inventory here"
        );
    }

    public static CustomItem menuClose() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_CLOSE),
                Theme.GUI_HEAD + "Close"
        );
    }

    public static CustomItem menuRenameCell() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_RENAME_CELL),
                Theme.GUI_HEAD + "Rename Cell"
        );
    }

    public static CustomItem menuSetMaterial() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_SET_ICON),
                Theme.GUI_HEAD + "Set Icon",
                "",
                Theme.ITEM_TYPEDESC + "Click this with an item on your",
                Theme.ITEM_TYPEDESC + "mouse to set the icon for this inventory"
        );
    }

    public static CustomItem menuCell(int number, @Nullable String name, @Nullable Material material, NetworkElement networkElement) {

        if (name == null) {
            name = ChatColor.WHITE + "Scanned Inventory";
        }

        ItemStack i;
        if (material == null) {
            i = SkullItem.fromBase64(Skulls.BLOCK_CELL_BASIC);
        } else {
            i = new ItemStack(material);
        }

        if (networkElement.getType() == NetworkElement.NetworkElementType.INVENTORY_CELL) {
            return menuCellNormal(i, name);
        } else if (
                networkElement.getType() == NetworkElementType.INFINITY_BARREL ||
                networkElement.getType() == NetworkElementType.FLUFFY_BARREL
        ) {
            return menuCellBarrel(i, name, networkElement);
        } else {
            return menuCellError();
        }
    }

    public static CustomItem menuCellNormal(ItemStack i, String name) {
        return new CustomItem(
                i,
                Theme.GUI_HEAD + name,
                "",
                Theme.ITEM_TYPEDESC + "Inventory Type: " + NetworkElement.networkElementTypeName(NetworkElement.NetworkElementType.INVENTORY_CELL),
                "",
                Theme.CLICK_INFO + "Left click: " + ChatColor.WHITE + "Open inventory",
                Theme.CLICK_INFO + "Right click: " + ChatColor.WHITE + "Highlight inventory"
        );
    }

    public static CustomItem menuCellBarrel(ItemStack i, String name, NetworkElement networkElement) {
        String barrelAmount = Theme.ITEM_TYPEDESC + "Content: " + ChatColor.WHITE + networkElement.getBarrelAmount();
        return new CustomItem(
                i,
                Theme.GUI_HEAD + name,
                "",
                Theme.ITEM_TYPEDESC + "Inventory Type: " + NetworkElement.networkElementTypeName(networkElement.getType()),
                "",
                barrelAmount,
                "",
                Theme.CLICK_INFO + "Left click: " + ChatColor.WHITE + "Open inventory",
                Theme.CLICK_INFO + "Right click: " + ChatColor.WHITE + "Highlight inventory"
        );
    }

    public static CustomItem menuCellError() {
        return new CustomItem(
                Material.BARRIER,
                Theme.GUI_HEAD + "Scanned Inventory (Error)",
                "",
                Theme.ITEM_TYPEDESC + "Inventory Type: Unknown/Error",
                "",
                Theme.CLICK_INFO + "Left click: " + ChatColor.WHITE + "Open inventory",
                Theme.CLICK_INFO + "Right click: " + ChatColor.WHITE + "Highlight inventory"
        );
    }


}
