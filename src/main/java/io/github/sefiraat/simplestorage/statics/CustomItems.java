package io.github.sefiraat.simplestorage.statics;

import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;

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

}
