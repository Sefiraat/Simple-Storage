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

public class GemProustite extends AbstractGem {

    private final NamespacedKey key;

    public GemProustite(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super("Proustite Crystal", category, item, recipeType, recipe, 2);
        this.key = new NamespacedKey(SimpleStorage.inst(), "proustite_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        if (environment == World.Environment.NETHER) {
            return 2;
        }
        return 0;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

}