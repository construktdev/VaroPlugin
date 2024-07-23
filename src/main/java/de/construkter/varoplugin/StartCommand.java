package de.construkter.varoplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.ChatColor.GOLD;

public class StartCommand implements CommandExecutor {
    private final VaroPlugin plugin;

    static boolean isStarted = false;
    static boolean protectTimeOver = false;

    public StartCommand(VaroPlugin plugin) {
        this.plugin = plugin;
    }

    public static boolean getStart() {
        return isStarted;
    }

    public static boolean getProtectTimeOver() {
        return protectTimeOver;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player && commandSender.hasPermission("*")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doImmediateRespawn true");
            new BukkitRunnable() {
                int countdown = 10;

                @Override
                public void run() {
                    if (countdown > 0) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle(GOLD + "Varo wird gestartet...", ChatColor.AQUA + String.valueOf(countdown), 0, 20, 0);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survival " + player.getName());
                        }
                        Bukkit.broadcastMessage(GOLD + "Noch " + countdown + " Sekunden!");
                        countdown--;
                    } else {
                        Bukkit.broadcastMessage(GOLD + "Los gehts!");
                        Bukkit.broadcastMessage(ChatColor.GRAY + "Baue einen Erd-Block neben dir ab und setze ihn uneter dich um aus dem Loch herauszukommen. danach musst du dich schnell ausrüsten, denn nach 10 Minuten ist die Schutzzeit zu ende und PVP aktiviert! Aber Achtung! Dir Welt ist begrenzt. Wer zu letzt lebt hat gewonnen!");
                        isStarted = true;
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0L, 20L);

            new BukkitRunnable() {
                int countdown = 600;
                @Override
                public void run() {
                    if (countdown > 0) {
                        if (countdown == 300){
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                player.sendMessage(ChatColor.GOLD + "Die Schutzzeit dauert noch " + ChatColor.BOLD + "5 Minuten" + ChatColor.GOLD + "!");
                            }
                        } else if (countdown < 10) {
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ACHTUNG! " + ChatColor.RED + " Die Schutzzeit endet in " + ChatColor.BOLD + countdown+ " Sekunden" + ChatColor.RED + "!");
                        } else if (countdown == 0) {
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ACHTUNG! " + ChatColor.RED + " Die Schutzzeit ist nun zuende! Du kannst nun Spieler angreifen, aber sie dich auch!");
                            protectTimeOver = true;
                            this.cancel();
                        }
                        countdown--;
                    }
                }
            }.runTaskTimer(plugin, 0L, 20L);
            return true;
        }
        return false;
    }
}
