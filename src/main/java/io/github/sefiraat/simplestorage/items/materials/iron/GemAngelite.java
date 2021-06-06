package io.github.sefiraat.simplestorage.items.materials.iron;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.sefiraat.simplestorage.statics.Skulls;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GemAngelite extends UnplaceableBlock implements NotPlaceable, GEOResource {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ANGELITE",
            Skulls.ITEM_ANGELITE,
            Messages.THEME_ITEM_CRAFTING + "Angelite Crystal",
            "",
            Messages.THEME_PASSIVE + "Angelite crystals are a rare resource that",
            Messages.THEME_PASSIVE + "are used for simple data transfer.",
            Messages.THEME_PASSIVE + "More plentiful in colder climates.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Base Resource"
    );

    private final NamespacedKey key;

    public GemAngelite(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.key = new NamespacedKey(SimpleStorage.getInstance(), "angelite_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        switch (environment) {
            case NORMAL:
                switch (biome) {
                    case SNOWY_BEACH:
                    case SNOWY_MOUNTAINS:
                    case SNOWY_TAIGA:
                    case SNOWY_TAIGA_HILLS:
                    case SNOWY_TAIGA_MOUNTAINS:
                    case SNOWY_TUNDRA:
                    case COLD_OCEAN:
                    case DEEP_COLD_OCEAN:
                        return 25;
                    case ICE_SPIKES:
                    case FROZEN_OCEAN:
                    case FROZEN_RIVER:
                    case DEEP_FROZEN_OCEAN:
                        return 40;
                    default:
                        return 5;
                }
            case NETHER:
                return 0;
            default:
                return 15;
        }
    }

    @Override
    public int getMaxDeviation() {
        return 5;
    }

    @Override
    public @NotNull String getName() {
        return "Angelite Crystal";
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return true;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }

}
