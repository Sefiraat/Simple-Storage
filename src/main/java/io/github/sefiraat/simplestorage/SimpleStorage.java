package io.github.sefiraat.simplestorage;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.sefiraat.simplestorage.categories.Categories;
import io.github.sefiraat.simplestorage.configuration.ManagerConfiguration;
import io.github.sefiraat.simplestorage.items.Blocks;
import io.github.sefiraat.simplestorage.items.Items;
import io.github.sefiraat.simplestorage.items.Machines;
import io.github.sefiraat.simplestorage.items.Materials;
import io.github.sefiraat.simplestorage.listeners.ManagerListeners;
import io.github.sefiraat.simplestorage.runnables.ManagerRunnables;

import javax.annotation.Nonnull;
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
    protected void onAddonEnable() {

        instance = this;

        getLogger().info("########################################");
        getLogger().info("              SimpleStorage             ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("########################################");

        managerConfiguration = new ManagerConfiguration(this);
        managerRunnables = new ManagerRunnables(this);
        managerListeners = new ManagerListeners();

        setupSlimefun();
    }

    @Override
    protected void onAddonDisable() {
        saveConfig();
        managerConfiguration.saveAdditionalConfigs();
        instance = null;
    }

    @Override
    protected Metrics setupMetrics() {
        return new Metrics(this,11622);
    }

    @Override
    protected @Nonnull
    String getGithubPath() {
        return "Sefiraat/Simple-Storage/master";
    }

    private void setupSlimefun() {
        Categories.set(this);
        Materials.set(this);
        Machines.set();
        Blocks.set(this);
        Items.set(this);
    }


}
