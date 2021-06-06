package io.github.sefiraat.simplestorage.configuration;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class ManagerConfiguration {

    private final SimpleStorage plugin;

    private final ConfigStrings strings;
    private final ConfigBooleans bools;
    private File chestConfigFile;
    private FileConfiguration chestConfig;

    public ConfigStrings getStrings() {
        return strings;
    }
    public ConfigBooleans getBools() {
        return bools;
    }
    public File getChestConfigFile() {
        return chestConfigFile;
    }
    public FileConfiguration getChestConfig() {
        return chestConfig;
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
        createChestConfig();
    }

    public void saveAdditionalConfigs() {
        saveChestConfig();
    }

    private void createChestConfig() {
        chestConfigFile = new File(plugin.getDataFolder(), "chest_contents.yml");
        if (!chestConfigFile.exists()) {
            chestConfigFile.getParentFile().mkdirs();
            plugin.saveResource("chest_contents.yml", false);
        }
        chestConfig = new YamlConfiguration();
        try {
            chestConfig.load(chestConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void saveChestConfig() {
        try {
            chestConfig.save(chestConfigFile);
        } catch (IOException e) {
            plugin.getLogger().warning("Unable to save " + chestConfigFile.getName());
        }
    }

    public static Integer getNextChestID() {
        FileConfiguration c = SimpleStorage.getInstance().getManagerConfiguration().chestConfig;
        ConfigurationSection section = c.getConfigurationSection("CHESTS");
        int nextValue = 1;
        if (section != null) {
            for (String key : section.getKeys(false)) {
                int value = Integer.parseInt(key);
                if (value > nextValue) {
                    nextValue = value;
                }
            }
            nextValue++;
        }
        return nextValue;
    }

    public static void removeChestID(int id) {
        FileConfiguration c = SimpleStorage.getInstance().getManagerConfiguration().chestConfig;
        c.set("CHESTS." + id, null);
    }

    public static void setupChest(Integer id) {
        FileConfiguration c = SimpleStorage.getInstance().getManagerConfiguration().getChestConfig();
        c.set("CHESTS." + id + ".PLACED", true);
    }

    public static void setChestSlotItem(int id, int slot, ItemStack itemStack) {
        FileConfiguration c = SimpleStorage.getInstance().getManagerConfiguration().getChestConfig();
        c.set("CHESTS." + id + ".SLOT-" + slot, itemStack);
    }

    public static ItemStack getChestSlotItem(int id, int slot, ItemStack itemStack) {
        FileConfiguration c = SimpleStorage.getInstance().getManagerConfiguration().getChestConfig();
        return c.getItemStack("CHESTS." + id + ".SLOT-" + slot, itemStack);
    }

}
