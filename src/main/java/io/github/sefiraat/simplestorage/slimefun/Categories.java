package io.github.sefiraat.simplestorage.slimefun;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.CustomItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.NamespacedKey;

public final class Categories {

    private Categories() {
        throw new IllegalStateException("Utility class");
    }

    public static final Category SIMPLE_STORAGE_MATERIALS = new Category(new NamespacedKey(SimpleStorage.inst(), "simple-storage-materials"), CustomItems.catSimpleStorageMaterials());
    public static final Category SIMPLE_STORAGE_MAIN = new Category(new NamespacedKey(SimpleStorage.inst(), "simple-storage-main"), CustomItems.catSimpleStorageMain());

    public static void set(SimpleStorage plugin) {
        SIMPLE_STORAGE_MATERIALS.register(plugin);
        SIMPLE_STORAGE_MAIN.register(plugin);
    }

}
