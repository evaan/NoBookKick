package com.obamabob.nobookkick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class NoBookKick extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for(Player player : getServer().getOnlinePlayers()) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.WRITTEN_BOOK && ((BookMeta) player.getInventory().getItemInMainHand().getItemMeta()).getPage(1).contains("\u0800") && ((BookMeta) player.getInventory().getItemInMainHand().getItemMeta()).getPageCount() >= 1) {
                        player.sendMessage(ChatColor.RED + "Sorry, a symbol you used in the book is currently blocked due to an exploit.");
                        player.getInventory().setItemInMainHand(new ItemStack(Material.WRITABLE_BOOK));
                    }
                }
            }
        }, 1l, 1l);
    }
}
