package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigBooleans {

    FileConfiguration configuration;

    public boolean getAutoUpdate() {
        return configuration.getBoolean("OPTIONS.AUTO-UPDATE");
    }

    public ConfigBooleans(SimpleStorage plugin) {
        configuration = plugin.getConfig();
    }

}
