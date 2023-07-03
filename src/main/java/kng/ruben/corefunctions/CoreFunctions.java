package kng.ruben.corefunctions;

import kng.ruben.corefunctions.commands.ClearChatCommand;
import kng.ruben.corefunctions.commands.HealCommand;
import kng.ruben.corefunctions.commands.InvseeCommand;
import kng.ruben.corefunctions.listener.AsyncPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoreFunctions extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("heal").setExecutor(new HealCommand());

        var pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new AsyncPlayerChatListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
