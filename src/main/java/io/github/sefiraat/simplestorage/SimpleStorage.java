package io.github.sefiraat.simplestorage;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.sefiraat.simplestorage.configuration.ManagerConfiguration;
import io.github.sefiraat.simplestorage.items.Blocks;
import io.github.sefiraat.simplestorage.items.Machines;
import io.github.sefiraat.simplestorage.items.Materials;
import io.github.sefiraat.simplestorage.listeners.ManagerListeners;
import io.github.sefiraat.simplestorage.runnables.ManagerRunnables;
import io.github.sefiraat.simplestorage.slimefun.Categories;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SimpleStorage extends AbstractAddon {

    private static SimpleStorage instance;
    public static SimpleStorage inst() {
        return instance;
    }

    private ManagerConfiguration managerConfiguration;
    private ManagerRunnables managerRunnables;
    private ManagerListeners managerListeners;

    private final Random random = new Random();

    public ManagerConfiguration getManagerConfiguration() {
        return managerConfiguration;
    }
    public ManagerRunnables getManagerRunnables() {
        return managerRunnables;
    }
    public ManagerListeners getManagerListeners() {
        return managerListeners;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    protected void enable() {

        instance = this;

        getLogger().info("########################################");
        getLogger().info("");
        getLogger().info("              SimpleStorage             ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("");
        getLogger().info("########################################");

        managerConfiguration = new ManagerConfiguration(this);
        managerRunnables = new ManagerRunnables(this);
        managerListeners = new ManagerListeners();

        setupSlimefun();

    }

    @Override
    protected void disable() {
        saveConfig();
        managerConfiguration.saveAdditionalConfigs();
        instance = null;
    }

    @Override
    protected Metrics setupMetrics() {
        return new Metrics(this,11622);
    }

    @Override
    protected @NotNull String getGithubPath() {
        return "Sefiraat/Simple-Storage/master";
    }

    @Override
    public String getAutoUpdatePath() {
        return null;
    }


    private void setupSlimefun() {
        Categories.set(this);
        Materials.set(this);
        Machines.set(this);
        Blocks.set(this);
    }


}
