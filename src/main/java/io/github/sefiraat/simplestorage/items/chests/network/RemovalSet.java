package io.github.sefiraat.simplestorage.items.chests.network;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.inventory.ItemStack;

public class RemovalSet {
    private final ItemStack originalGuiClose;
    private final ChestMenu.MenuClickHandler closeMenuClickHandler;
    private final ItemStack originalGuiRename;
    private final ChestMenu.MenuClickHandler renameMenuClickHandler;
    private final ItemStack originalGuiBlock;
    private final ChestMenu.MenuClickHandler blockMenuClickHandler;

    public ItemStack getOriginalGuiClose() {
        return originalGuiClose;
    }

    public ChestMenu.MenuClickHandler getCloseMenuClickHandler() {
        return closeMenuClickHandler;
    }

    public ItemStack getOriginalGuiRename() {
        return originalGuiRename;
    }

    public ChestMenu.MenuClickHandler getRenameMenuClickHandler() {
        return renameMenuClickHandler;
    }

    public ItemStack getOriginalGuiBlock() {
        return originalGuiBlock;
    }

    public ChestMenu.MenuClickHandler getBlockMenuClickHandler() {
        return blockMenuClickHandler;
    }

    public RemovalSet(ItemStack i1, ChestMenu.MenuClickHandler h1, ItemStack i2, ChestMenu.MenuClickHandler h2, ItemStack i3, ChestMenu.MenuClickHandler h3) {
        originalGuiClose = i1;
        closeMenuClickHandler = h1;
        originalGuiRename = i2;
        renameMenuClickHandler = h2;
        originalGuiBlock = i3;
        blockMenuClickHandler = h3;
    }
}
