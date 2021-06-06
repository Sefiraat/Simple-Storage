package io.github.sefiraat.simplestorage.listeners;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.materials.diamond.AntimonyChunk;
import io.github.sefiraat.simplestorage.items.materials.general_loop_one.ChromiteChunk;
import io.github.sefiraat.simplestorage.items.materials.gold.BastnaesiteChunk;
import io.github.sefiraat.simplestorage.statics.Utils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    public BlockBreakListener() {
        SimpleStorage.getInstance().getServer().getPluginManager().registerEvents(this, SimpleStorage.getInstance());
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
                }
            }
        }
    }

    private void triggerRedstone(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.getInstance().getRandom(), 1, 100);
        event.getPlayer().sendMessage("" + randomInt);
        if (randomInt > 70) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), ChromiteChunk.STACK.clone());
        }
    }

    private void triggerDiamond(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.getInstance().getRandom(), 1, 100);
        event.getPlayer().sendMessage("" + randomInt);
        if (randomInt > 80) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), BastnaesiteChunk.STACK.clone());
        }
    }

    private void triggerEmerald(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.getInstance().getRandom(), 1, 100);
        event.getPlayer().sendMessage("" + randomInt);
        if (randomInt > 90) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), AntimonyChunk.STACK.clone());
        }
    }


}
