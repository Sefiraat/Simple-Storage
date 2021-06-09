package io.github.sefiraat.simplestorage.items.materials;

import io.github.sefiraat.simplestorage.SimpleStorage;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GemShortite extends AbstractGem {

    private final NamespacedKey key;

    public GemShortite(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super("Shortite Crystal", category, item, recipeType, recipe, 1);
        this.key = new NamespacedKey(SimpleStorage.inst(), "shortite_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        if (environment == World.Environment.THE_END) {
            return 1;
        }
        return 0;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

}
