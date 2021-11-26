package io.github.sefiraat.simplestorage.listeners;

import io.github.sefiraat.simplestorage.SimpleStorage;
import io.github.sefiraat.simplestorage.items.SimpleStorageItemStacks;
import io.github.sefiraat.simplestorage.utils.Utils;
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

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.isCancelled()) {
            ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
            if (!itemStack.containsEnchantment(Enchantment.SILK_TOUCH)) {
                switch (event.getBlock().getType()) {
                    case COAL_ORE:
                        coal(event);
                        break;
                    case NETHER_QUARTZ_ORE:
                        quartz(event);
                        break;
                    case REDSTONE_ORE:
                        redstone(event);
                        break;
                    case LAPIS_ORE:
                        lapis(event);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void coal(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 90) {
            int dropAmt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 3);
            ItemStack dropStack = SimpleStorageItemStacks.CHUNK_CHROMITE.clone();
            dropStack.setAmount(dropAmt);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), dropStack);
        }
    }

    private void quartz(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 80) {
            int dropAmt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 3);
            ItemStack dropStack = SimpleStorageItemStacks.CHUNK_BASTNAESITE.clone();
            dropStack.setAmount(dropAmt);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), dropStack);
        }
    }

    private void redstone(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 70) {
            int dropAmt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 3);
            ItemStack dropStack = SimpleStorageItemStacks.RHENIUM_CHUNK.clone();
            dropStack.setAmount(dropAmt);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), dropStack);
        }
    }

    private void lapis(BlockBreakEvent event) {
        int randomInt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 100);
        if (randomInt > 70) {
            int dropAmt = Utils.randInt(SimpleStorage.inst().getRandom(), 1, 2);
            ItemStack dropStack = SimpleStorageItemStacks.CHUNK_ANTIMONY.clone();
            dropStack.setAmount(dropAmt);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), dropStack);
        }
    }


}
