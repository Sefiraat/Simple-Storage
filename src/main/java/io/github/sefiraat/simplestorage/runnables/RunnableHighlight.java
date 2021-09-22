package io.github.sefiraat.simplestorage.runnables;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class RunnableHighlight extends BukkitRunnable {

    private final Location startLoc;
    private final Location endLoc;
    private final Particle.DustOptions dustOptions;
    private int runs = 5;

    public RunnableHighlight(Location startLoc, Location endLoc) {
        this.startLoc = startLoc;
        this.endLoc = endLoc;

        dustOptions = new Particle.DustOptions(Color.fromRGB(255, 255, 40), 1);
    }

    @Override
    public void run() {
        if (runs <= 0) {
             this.cancel();
        } else {
            spawnParticleAlongLine(startLoc, endLoc, Particle.REDSTONE, 20, 2, 0, 0, 0, 0, dustOptions, true);
            runs--;
        }
    }

    // Modified version of https://www.spigotmc.org/threads/spawn-particles-between-two-locations-along-a-line.451048/
    public void spawnParticleAlongLine(Location start, Location end, Particle particle, int pointsPerLine, int particleCount, double offsetX, double offsetY,
                                       double offsetZ, double extra, Particle.DustOptions options, boolean forceDisplay) {
        double d = start.distance(end) / pointsPerLine;
        for (int i = 0; i < pointsPerLine; i++) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());
            start.getWorld().spawnParticle(particle, l, particleCount, offsetX, offsetY, offsetZ, extra, options, forceDisplay);
            options = new Particle.DustOptions(Color.fromRGB(
                    options.getColor().getRed() - 10,
                    options.getColor().getGreen() - 5,
                    options.getColor().getBlue() + 10
            ), 1);
        }
    }

}