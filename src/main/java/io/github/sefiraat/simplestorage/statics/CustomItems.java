package io.github.sefiraat.simplestorage.statics;

import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class CustomItems {

    private CustomItems() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem catSimpleStorageMaterials() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.CAT_MATERIALS),
                Messages.THEME_MAIN + "Simple Storage Skulls"
        );
    }

    public static CustomItem catSimpleStorageMain() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.CAT_MAIN),
                Messages.THEME_MAIN + "Simple Storage"
        );
    }

    public static CustomItem menuBackground() {
        return new CustomItem(
                Material.GRAY_STAINED_GLASS_PANE,
                Messages.THEME_PASSIVE + "Simple!",
                ""
        );
    }

    public static CustomItem menuInfo() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_NO1),
                Messages.THEME_GUI_HEAD + "Info",
                "",
                "Page number : 1"
        );
    }

    public static CustomItem menuChestPageBack() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_BACK),
                Messages.THEME_GUI_HEAD + "Back",
                "",
                Messages.THEME_CLICK_INFO + "Click to navigate back a page."
        );
    }

    public static CustomItem menuChestPageForward() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_FORWARD),
                Messages.THEME_GUI_HEAD + "Forward",
                "",
                Messages.THEME_CLICK_INFO + "Click to navigate forward a page."
        );
    }

    public static CustomItem menuChestDummy() {
        return new CustomItem(
                Material.LIGHT_GRAY_STAINED_GLASS_PANE,
                Messages.THEME_PASSIVE + "No item here"
        );
    }

    public static CustomItem menuMasterDummy() {
        return new CustomItem(
                Material.LIGHT_GRAY_STAINED_GLASS_PANE,
                Messages.THEME_PASSIVE + "No inventory here"
        );
    }

    public static CustomItem menuClose() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_CLOSE),
                Messages.THEME_GUI_HEAD + "Close"
        );
    }

    public static CustomItem menuRenameCell() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_RENAME_CELL),
                Messages.THEME_GUI_HEAD + "Rename Cell"
        );
    }

    public static CustomItem menuSetMaterial() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.GUI_SET_ICON),
                Messages.THEME_GUI_HEAD + "Set Icon",
                "",
                Messages.THEME_ITEM_TYPEDESC + "Click this with an item on your",
                Messages.THEME_ITEM_TYPEDESC + "mouse to set the icon for this inventory"
        );
    }

    public static CustomItem menuCell(int number, @Nullable String name, @Nullable Material material) {
        if (name == null) {
            name = ChatColor.WHITE + "Scanned Inventory";
        }
        ItemStack i;
        if (material == null) {
            i = SkullItem.fromBase64(Skulls.BLOCK_CELL_BASIC);
        } else {
            i = new ItemStack(material);
        }
        return new CustomItem(
                i,
                Messages.THEME_GUI_HEAD + name,
                "",
                Messages.THEME_ITEM_TYPEDESC + "Cell number: " + number
        );
    }


}
