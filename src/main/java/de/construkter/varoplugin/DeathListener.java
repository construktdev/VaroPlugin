package de.construkter.varoplugin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity().getPlayer();
        assert p != null;
        p.sendTitle(ChatColor.RED + "Gestorben!", ChatColor.AQUA + "Du musst nun zuschauen", 10, 10, 10);
        p.sendMessage(ChatColor.RED + "Nutze /hub um jederzeit in die Lobby zu wechseln");
        p.setGameMode(GameMode.SPECTATOR);
    }
}
