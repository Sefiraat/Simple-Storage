package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;

public class ManagerConfiguration {

    private SimpleStorage plugin;

    private final ConfigStrings strings;
    private final ConfigBooleans bools;


    public ConfigStrings getStrings() {
        return strings;
    }
    public ConfigBooleans getBools() {
        return bools;
    }

    public ManagerConfiguration(SimpleStorage plugin) {

        this.plugin = plugin;

        strings = new ConfigStrings(plugin);
        bools = new ConfigBooleans(plugin);

        sortConfigs();
    }

    private void sortConfigs() {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        createAdditionalConfigs();
    }

    private void createAdditionalConfigs() {

    }

    public void saveAdditionalConfigs() {

    }

}
