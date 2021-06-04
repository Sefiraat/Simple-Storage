package io.github.sefiraat.simplestorage.statics;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    public static final String PREFIX = "" + ChatColor.GRAY + "[Simple Storage] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final ChatColor THEME_WARNING = ChatColor.YELLOW;
    public static final ChatColor THEME_ERROR = ChatColor.RED;
    public static final ChatColor THEME_NOTICE = ChatColor.WHITE;
    public static final ChatColor THEME_PASSIVE = ChatColor.GRAY;
    public static final ChatColor THEME_SUCCESS = ChatColor.GREEN;
    public static final ChatColor THEME_MAIN = ChatColor.of("#21588f");
    public static final ChatColor THEME_ITEM_CRAFTING = ChatColor.of("#dbcea9");
    public static final ChatColor THEME_ITEM_MACHINE = ChatColor.of("#3295a8");
    public static final ChatColor THEME_ITEM_TYPEDESC = ChatColor.of("#f0ea4f");


    private Messages() {
        throw new IllegalStateException("Utility class");
    }

}
