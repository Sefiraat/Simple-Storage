package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigBooleans {

    final FileConfiguration configuration;

    public boolean getAutoUpdate() {
        return configuration.getBoolean("auto-update");
    }

    public ConfigBooleans(SimpleStorage plugin) {
        configuration = plugin.getConfig();
    }

}
