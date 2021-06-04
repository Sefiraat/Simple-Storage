package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigStrings {

    FileConfiguration configuration;

    public ConfigStrings(SimpleStorage plugin) {
        configuration = plugin.getConfig();
    }

}
