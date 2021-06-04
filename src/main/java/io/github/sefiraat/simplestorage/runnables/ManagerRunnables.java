package io.github.sefiraat.simplestorage.runnables;

import io.github.sefiraat.simplestorage.SimpleStorage;

public class ManagerRunnables {

    private final SimpleStorage plugin;

    private RunnableSave runnableSave;

    public RunnableSave getRunnableSave() {
        return runnableSave;
    }


    public ManagerRunnables(SimpleStorage plugin) {
        this.plugin = plugin;
        setupRunnables();
    }

    private void setupRunnables() {

        runnableSave = new RunnableSave(plugin);
        runnableSave.runTaskTimer(plugin, 0, 100L);

    }


}
