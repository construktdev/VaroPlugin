package de.construkter.varoplugin.beforeStart;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TeleportPlayers implements Listener {
    static int tpindex = 0;
    static String[] tplocs = new String[10];
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        tplocs[0] = "2054.30 117.00 -203.44 2070.01 4.20";
        tplocs[1] = "2060.49 117.00 -207.50 2073.60 -4.35";
        tplocs[2] = "2068.70 117.00 -209.45 2159.85 0.45";
        tplocs[3] = "2075.70 117.00 -207.70 2205.29 7.05";
        tplocs[4] = "2073.55 117.00 -202.64 2240.55 -2.55";
        tplocs[5] = "2067.70 117.00 -200.62 2255.39 5.55";
        tplocs[6] = "2061.70 116.00 -197.62 2245.19 0.45";
        tplocs[7] = "2060.70 116.00 -192.30 2252.08 3.60";
        tplocs[8] = "2054.70 117.00 -197.30 2339.38 -0.90";
        tplocs[9] = "2068.41 117.00 -194.70 2610.72 3.00";
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + event.getPlayer().getDisplayName() + " " + tplocs[tpindex]);
        tpindex++;
    }
}
