package io.github.sefiraat.simplestorage;

import io.github.sefiraat.simplestorage.configuration.ManagerConfiguration;
import io.github.sefiraat.simplestorage.items.Blocks;
import io.github.sefiraat.simplestorage.items.Machines;
import io.github.sefiraat.simplestorage.items.SlimefunItemStacks;
import io.github.sefiraat.simplestorage.runnables.ManagerRunnables;
import io.github.sefiraat.simplestorage.slimefun.Categories;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class SimpleStorage extends JavaPlugin implements SlimefunAddon {

    private static SimpleStorage instance;
    public static SimpleStorage getInstance() {
        return instance;
    }

    private ManagerConfiguration managerConfiguration;
    private ManagerRunnables managerRunnables;

    public ManagerConfiguration getManagerConfiguration() {
        return managerConfiguration;
    }
    public ManagerRunnables getManagerRunnables() {
        return managerRunnables;
    }

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info("########################################");
        getLogger().info("");
        getLogger().info("              SimpleStorage             ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("");
        getLogger().info("########################################");

        managerConfiguration = new ManagerConfiguration(this);
        managerRunnables = new ManagerRunnables(this);

        setupSlimefun();

    }

    @Override
    public void onDisable() {
        saveConfig();
        managerConfiguration.saveAdditionalConfigs();
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }

    private void setupSlimefun() {
        Categories.set(this);
        SlimefunItemStacks.set(this);
        Machines.set(this);
        Blocks.set(this);
    }


}
