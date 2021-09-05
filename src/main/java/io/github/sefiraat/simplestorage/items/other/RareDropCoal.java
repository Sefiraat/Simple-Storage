package io.github.sefiraat.simplestorage.items.other;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class RareDropCoal {

    private RareDropCoal() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = new SlimefunItemStack(
            "MECHANIC_DROP_COAL",
            Material.COAL_ORE,
            Theme.ITEM_RARE_DROP + "Rare Drop: Coal",
            "",
            Theme.PASSIVE + "This item is a rare drop from",
            Theme.PASSIVE + "coal ore. The block actually needs",
            Theme.PASSIVE + "to break, no Silk Touch.",
            "",
            Theme.LORE_TYPE_DROP
    );

    public static final RecipeType TYPE = new RecipeType(new NamespacedKey(SimpleStorage.inst(), "drop-coal"), STACK, "");

}
