package io.github.sefiraat.simplestorage.items.materials;

import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractGem extends UnplaceableBlock implements NotPlaceable, GEOResource {

    private final int maxDeviation;
    private final String name;

    protected AbstractGem(String name, Category category, SlimefunItemStack slimefunItemStack, RecipeType recipeType, ItemStack[] recipe, int deviation) {
        super(category, slimefunItemStack, recipeType, recipe);
        this.maxDeviation = deviation;
        this.name = name;
    }

    @Override
    public int getMaxDeviation() {
        return maxDeviation;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return true;
    }

}
