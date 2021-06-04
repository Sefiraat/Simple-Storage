package io.github.sefiraat.simplestorage.runnables;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.scheduler.BukkitRunnable;

public class RunnableSave extends BukkitRunnable {

    public final SimpleStorage plugin;

    public RunnableSave(SimpleStorage plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.getManagerConfiguration().saveAdditionalConfigs();
    }
}