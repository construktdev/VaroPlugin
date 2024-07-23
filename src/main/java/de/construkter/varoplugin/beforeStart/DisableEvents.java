package de.construkter.varoplugin.beforeStart;

import de.construkter.varoplugin.StartCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DisableEvents implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (StartCommand.getStart()) return;
        event.setCancelled(true);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (StartCommand.getStart()) return;
        event.setCancelled(true);
    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity attacker = event.getDamager();
        if (StartCommand.getProtectTimeOver()) return;
        if ((attacker instanceof Player) && (entity instanceof Player)){ event.setCancelled(true);}


    }
}
