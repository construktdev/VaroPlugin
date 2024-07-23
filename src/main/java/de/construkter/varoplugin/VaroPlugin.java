package de.construkter.varoplugin;

import de.construkter.varoplugin.beforeStart.DisableEvents;
import de.construkter.varoplugin.beforeStart.TeleportPlayers;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaroPlugin extends JavaPlugin {
    private static VaroPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new TeleportPlayers(), this);
        getServer().getPluginManager().registerEvents(new DisableEvents(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        this.getCommand("start").setExecutor(new StartCommand(this));
        this.getCommand("hub").setExecutor(new LobbyCommand());
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getCommand("lobby").setExecutor(new LobbyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static VaroPlugin getInstance() {
        return instance;
    }
}
