package io.github.sefiraat.simplestorage.items.materials.diamond;

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

public class GemShortite extends UnplaceableBlock implements NotPlaceable, GEOResource {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_SHORTITE",
            Skulls.ITEM_SHORTITE,
            Messages.THEME_ITEM_CRAFTING + "Shortite Crystal",
            "",
            Messages.THEME_PASSIVE + "Shortite crystals are a rare resource that",
            Messages.THEME_PASSIVE + "are used for the most advanced data transfers.",
            Messages.THEME_PASSIVE + "Locations unknown.",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Base Resource"
    );

    private final NamespacedKey key;

    public GemShortite(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.key = new NamespacedKey(SimpleStorage.getInstance(), "shortite_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        switch (environment) {
            case THE_END:
                return 1;
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
        return "Shortite Crystal";
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
