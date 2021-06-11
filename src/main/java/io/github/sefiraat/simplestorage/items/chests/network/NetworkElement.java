package io.github.sefiraat.simplestorage.items.chests.network;

import io.github.sefiraat.simplestorage.utils.Theme;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class NetworkElement {

    private final Block block;
    private NetworkElementType type;
    private Material material;
    private String skullTexture;
    private int slotClose;
    private int slotRename;
    private int slotSetBlock;
    private int barrelAmount;

    public Block getBlock() {
        return block;
    }
    public NetworkElementType getType() {
        return type;
    }

    public void setType(NetworkElementType type) {
        this.type = type;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getSkullTexture() {
        return skullTexture;
    }

    public void setSkullTexture(String skullTexture) {
        this.skullTexture = skullTexture;
    }

    public int getSlotClose() {
        return slotClose;
    }

    public void setSlotClose(int slotClose) {
        this.slotClose = slotClose;
    }

    public int getSlotRename() {
        return slotRename;
    }

    public void setSlotRename(int slotRename) {
        this.slotRename = slotRename;
    }

    public int getSlotSetBlock() {
        return slotSetBlock;
    }

    public void setSlotSetBlock(int slotSetBlock) {
        this.slotSetBlock = slotSetBlock;
    }

    public int getBarrelAmount() {
        return barrelAmount;
    }

    public void setBarrelAmount(int barrelAmount) {
        this.barrelAmount = barrelAmount;
    }

    public NetworkElement(Block block, int slotClose, int slotRename, int slotSetBlock) {
        this.block = block;
        this.slotClose = slotClose;
        this.slotRename = slotRename;
        this.slotSetBlock = slotSetBlock;
    }

    public enum NetworkElementType {
        INVENTORY_CELL,
        INFINITY_BARREL,
        NONE
    }

    public static String networkElementTypeName(NetworkElementType type) {
        switch (type) {
            case INVENTORY_CELL: return Theme.MAIN + "Simple Storage Cell";
            case INFINITY_BARREL: return ChatColor.AQUA + "Infinity Storage Unit";
        }
        return "Uh oh, something went a bit wrong...";
    }
}
