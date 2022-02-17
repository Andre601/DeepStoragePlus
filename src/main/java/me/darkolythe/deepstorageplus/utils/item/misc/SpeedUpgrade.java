package me.darkolythe.deepstorageplus.utils.item.misc;

import me.darkolythe.deepstorageplus.utils.ItemList;
import me.darkolythe.deepstorageplus.utils.item.DSPItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class SpeedUpgrade implements DSPItem{
    
    private final ItemStack item;
    private final ItemMeta meta;
    
    public SpeedUpgrade() {
        this.item = new ItemStack(Material.PAPER);
        this.meta = Objects.requireNonNull(item.getItemMeta());
    
        meta.setCustomModelData(ItemList.SPEEDUPGRADE_MODEL_ID);
    }
    
    @Override
    public SpeedUpgrade setName(String name) {
        meta.setDisplayName(name);
        return this;
    }
    
    @Override
    public SpeedUpgrade setLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }
    
    @Override
    public SpeedUpgrade setItemMeta() {
        item.setItemMeta(meta);
        return this;
    }
    
    @Override
    public ItemStack getItem() {
        return item;
    }
    
    public SpeedUpgrade hideEnchantment() {
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }
    
    public SpeedUpgrade setEnchanted() {
        item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        return this;
    }
}