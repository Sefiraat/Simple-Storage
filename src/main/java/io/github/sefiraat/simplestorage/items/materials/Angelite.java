package io.github.sefiraat.simplestorage.items.materials;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.statics.Materials;
import io.github.sefiraat.simplestorage.statics.Messages;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Angelite extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable, GEOResource {

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MATERIAL_ANGELITE",
            Materials.ITEM_ANGELITE,
            Messages.THEME_ITEM_CRAFTING + "Angelite Crystal",
            "",
            Messages.THEME_PASSIVE + "Angelite crystals are a rare resource that",
            Messages.THEME_PASSIVE + "are used for simple data transfer",
            "",
            Messages.THEME_ITEM_TYPEDESC + "Crafting Material"
    );

    private final NamespacedKey key;

    public Angelite(SimpleStorage plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.key = new NamespacedKey(SimpleStorage.getInstance(), "angelite_crystal");
        register();
        register(plugin);
    }

    @Override
    public int getDefaultSupply(@NotNull World.Environment environment, @NotNull Biome biome) {
        return switch (environment) {
            case NORMAL -> switch (biome) {
                case SNOWY_BEACH, SNOWY_MOUNTAINS, SNOWY_TAIGA, SNOWY_TAIGA_HILLS, SNOWY_TAIGA_MOUNTAINS, SNOWY_TUNDRA, COLD_OCEAN, DEEP_COLD_OCEAN -> 25;
                case ICE_SPIKES, FROZEN_OCEAN, FROZEN_RIVER, DEEP_FROZEN_OCEAN -> 40;
                default -> 5;
            };
            case NETHER -> 0;
            default -> 15;
        };
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

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return PlayerRightClickEvent::cancel;
    }
}
