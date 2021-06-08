package io.github.sefiraat.simplestorage.statics;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class Utils {

    public static int randInt(Random r, int min, int max) {
        return r.nextInt((max - min) + 1) + min;
    }

    public static ItemStack setGuiItem(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer c = itemMeta.getPersistentDataContainer();
        c.set(new NamespacedKey(SimpleStorage.inst(), "gui"), PersistentDataType.INTEGER, 1);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
