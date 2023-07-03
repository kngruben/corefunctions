package kng.ruben.corefunctions.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ClearChatCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        for (int i = 0; i <= 100; i++) {
            Bukkit.getOnlinePlayers().forEach(player ->
                    player.sendMessage(Component.text("§a ")));
        }
        Bukkit.broadcast(Component.text("§cChat has been cleared by " + sender.getName() + ". "));

        return true;
    }
}
