package io.github.sefiraat.simplestorage.statics;

import io.github.sefiraat.simplestorage.SimpleStorage;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Random;

public class Utils {

    public static int randInt(Random r, int min, int max) {
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void debugMessage(String string) {
        SimpleStorage.getInstance().getLogger().info(string);
    }


}
