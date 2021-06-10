package io.github.sefiraat.simplestorage.runnables;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class RunnableHighlight extends BukkitRunnable {

    private final Location location;
    private final Particle.DustOptions dustOptions;
    public int runs = 5;

    public RunnableHighlight(Location location) {
        this.location = location;
        dustOptions = new Particle.DustOptions(Color.fromRGB(150, 20, 40), 2);
    }

    @Override
    public void run() {
        if (runs <= 0) {
             this.cancel();
        } else {
            location.getWorld().spawnParticle(Particle.REDSTONE, location,40,0.2,0.2,0.2,0.5, dustOptions,true);
            runs--;
        }
    }
}