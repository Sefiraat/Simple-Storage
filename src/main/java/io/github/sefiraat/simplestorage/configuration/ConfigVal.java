package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigVal {

    final FileConfiguration configuration;

    private final int networkRange;
    private final int networkTickRate;

    public int getNetworkRange() {
        return networkRange;
    }
    public int getNetworkTickRate() { return networkTickRate; }

    public ConfigVal(SimpleStorage plugin) {
        configuration = plugin.getConfig();
        networkRange = configuration.getInt("options.network-range");
        networkTickRate = configuration.getInt("options.ticks-between-checks");
    }

}
