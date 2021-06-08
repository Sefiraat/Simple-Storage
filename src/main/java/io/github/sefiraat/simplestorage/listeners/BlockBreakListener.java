package io.github.sefiraat.simplestorage.listeners;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.SlimefunItemStacks;
import io.github.sefiraat.simplestorage.statics.Utils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    public BlockBreakListener() {
        SimpleStorage.inst().getServer().getPluginManager().registerEvents(this, SimpleStorage.inst());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
            if (!itemStack.containsEnchantment(Enchantment.SILK_TOUCH)) {
                switch (event.getBlock().getType()) {
                    case REDSTONE_ORE:
                        triggerRedstone(event);
                        break;
                    case DIAMOND_ORE:
                        triggerDiamond(event);
                        break;
                    case EMERALD_ORE:
                        triggerEmerald(event);
                        break;
                    case LAPIS_ORE:
                        triggerLapis(event);
                        break;
                }
            }
        }
    }

    private void triggerRedstone(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 60) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), SlimefunItemStacks.CHUNK_CHROMITE.clone());
        }
    }

    private void triggerDiamond(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 65) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), SlimefunItemStacks.CHUNK_BASTNAESITE.clone());
        }
    }

    private void triggerEmerald(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 70) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), SlimefunItemStacks.CHUNK_ANTIMONY.clone());
        }
    }

    private void triggerLapis(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 75) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), SlimefunItemStacks.RHENIUM_CHUNK.clone());
        }
    }


}
