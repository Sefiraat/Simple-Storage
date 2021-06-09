package io.github.sefiraat.simplestorage.items.chests;

import io.github.sefiraat.simplestorage.statics.Theme;
import io.github.sefiraat.simplestorage.statics.Utils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;

import java.util.Map;

public abstract class AbstractCache {

    protected final BlockMenu blockMenu;
    protected int pages;
    protected int page = 1;
    protected final Map<Integer, String> guiNumbers;

    protected AbstractCache(BlockMenu blockMenu) {

        this.blockMenu = blockMenu;

        guiNumbers = Utils.infoSkulls();

        blockMenu.addMenuClickHandler(NetworkChest.SLOT_BACK, (player, i, itemStack, clickAction) -> {
            if (page > 1) {
                page-= 1;
            }
            int skullID = page;
            if (page > 20) {
                skullID = 21;
            }
            blockMenu.replaceExistingItem(0, new CustomItem(
                    SkullItem.fromBase64(guiNumbers.get(skullID)),
                    Theme.GUI_HEAD + "Info",
                    "",
                    Theme.CLICK_INFO + "Page number : " + page
            ));
            return false;
        });

        blockMenu.addMenuClickHandler(NetworkChest.SLOT_FORWARD, (player, i, itemStack, clickAction) -> {
            if (page < pages) {
                page+= 1;
            }
            int skullID = page;
            if (page > 20) {
                skullID = 21;
            }
            blockMenu.replaceExistingItem(0, new CustomItem(
                    SkullItem.fromBase64(guiNumbers.get(skullID)),
                    Theme.GUI_HEAD + "Info",
                    "",
                    Theme.CLICK_INFO + "Page number : " + page
            ));
            return false;
        });

        blockMenu.addMenuClickHandler(SimpleChest.SLOT_INFO, ((player, i, itemStack, clickAction) -> false));
    }
}
