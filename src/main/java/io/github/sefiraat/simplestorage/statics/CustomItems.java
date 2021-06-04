package io.github.sefiraat.simplestorage.statics;

import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;

public final class CustomItems {

    private CustomItems() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem catSimpleStorageMaterials() {
        return new CustomItem(
                SkullItem.fromBase64(Materials.CAT_MATERIALS),
                Messages.THEME_MAIN + "Simple Storage Materials"
        );
    }

    public static CustomItem catSimpleStorageMain() {
        return new CustomItem(
                SkullItem.fromBase64(Materials.CAT_MAIN),
                Messages.THEME_MAIN + "Simple Storage"
        );
    }

}
