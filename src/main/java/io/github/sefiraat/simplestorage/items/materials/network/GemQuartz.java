package io.github.sefiraat.simplestorage.items.materials.network;

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

public class GemQuartz extends UnplaceableBlock implements NotPlaceable, GEOResource {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_QUARTZGEM",
            Skulls.ITEM_CLEAR_QUARTZ,
            Messages.THEME_ITEM_CRAFTING + "Crystal Clear Quartz",
            "",
            Messages.THEME_PASSIVE + "This form of quartz is very rare",
            Messages.THEME_PASSIVE + "and used for creating displays.",
            Messages.THEME_PASSIVE + "Location unknown.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Base Resource"
    );

    private final NamespacedKey key;

    public GemQuartz(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.key = new NamespacedKey(SimpleStorage.inst(), "quartz_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        switch (environment) {
            case NORMAL:
                switch (biome) {
                    case FLOWER_FOREST:
                        return 2;
                    case MUSHROOM_FIELDS:
                    case MUSHROOM_FIELD_SHORE:
                        return 4;
                    default:
                        return 0;
                }
            default:
                return 0;
        }
    }

    @Override
    public int getMaxDeviation() {
        return 1;
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
