package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigVal {

    FileConfiguration configuration;

    public int getNetworkRange() {
        return configuration.getInt("options.network-range");
    }
    public int getNetworkTickRate() { return configuration.getInt("options.ticks-between-checks"); }

    public ConfigVal(SimpleStorage plugin) {
        configuration = plugin.getConfig();
    }

}
