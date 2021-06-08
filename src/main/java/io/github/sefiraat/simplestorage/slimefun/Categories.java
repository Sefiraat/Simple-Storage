package io.github.sefiraat.simplestorage.slimefun;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.sefiraat.simplestorage.statics.Theme;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.NamespacedKey;

public final class Categories {

    private Categories() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem catSimpleStorageMaterials() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.CAT_MATERIALS),
                Theme.MAIN + "Simple Storage Materials"
        );
    }

    public static CustomItem catSimpleStorageMain() {
        return new CustomItem(
                SkullItem.fromBase64(Skulls.CAT_MAIN),
                Theme.MAIN + "Simple Storage"
        );
    }

    public static final Category MAT = new Category(new NamespacedKey(SimpleStorage.inst(), "simple-storage-materials"), catSimpleStorageMaterials());
    public static final Category MAIN = new Category(new NamespacedKey(SimpleStorage.inst(), "simple-storage-main"), catSimpleStorageMain());

    public static void set(SimpleStorage plugin) {
        MAT.register(plugin);
        MAIN.register(plugin);
    }

}
