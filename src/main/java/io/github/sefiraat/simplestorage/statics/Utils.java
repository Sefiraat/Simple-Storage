package io.github.sefiraat.simplestorage.statics;

import io.github.sefiraat.simplestorage.SimpleStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

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

    public static void setUpChestMenu(BlockMenuPreset blockMenuPreset, int[] background, int slotBack, int slotForward, int slotInfo) {
        blockMenuPreset.setSize(54);
        blockMenuPreset.drawBackground(GuiItems.menuBackground(), background);
        blockMenuPreset.addItem(slotBack, GuiItems.menuChestPageBack());
        blockMenuPreset.addItem(slotForward, GuiItems.menuChestPageForward());
        blockMenuPreset.addItem(slotInfo, GuiItems.menuInfo());
    }

    public static Map<Integer, String> infoSkulls() {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, Skulls.GUI_NO1);
        m.put(2, Skulls.GUI_NO2);
        m.put(3, Skulls.GUI_NO3);
        m.put(4, Skulls.GUI_NO4);
        m.put(5, Skulls.GUI_NO5);
        m.put(6, Skulls.GUI_NO6);
        m.put(7, Skulls.GUI_NO7);
        m.put(8, Skulls.GUI_NO8);
        m.put(9, Skulls.GUI_NO9);
        m.put(10, Skulls.GUI_NO10);
        m.put(11, Skulls.GUI_NO11);
        m.put(12, Skulls.GUI_NO12);
        m.put(13, Skulls.GUI_NO13);
        m.put(14, Skulls.GUI_NO14);
        m.put(15, Skulls.GUI_NO15);
        m.put(16, Skulls.GUI_NO16);
        m.put(17, Skulls.GUI_NO17);
        m.put(18, Skulls.GUI_NO18);
        m.put(19, Skulls.GUI_NO19);
        m.put(20, Skulls.GUI_NO20);
        m.put(21, Skulls.GUI_NOPLUS);
        return m;
    }


}
