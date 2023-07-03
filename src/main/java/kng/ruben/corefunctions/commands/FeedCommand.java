package kng.ruben.corefunctions.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command is only for players.");
            return false;
        }

        if (args.length == 0) {
            feedPlayer(player);
            player.sendMessage("§aYou successfully fed yourself.");

            return true;
        }
        var target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cThis player is not online, so you cannot feed him.");
            return false;
        } else if (target == player) {
            feedPlayer(player);
            player.sendMessage("§aYou successfully fed yourself.");
            return true;
        }
        feedPlayer(target);

        player.sendMessage("§aYou successfully fed " + target.getName() + ".");
        target.sendMessage("§aYou got fed by " + player.getName() + ".");

        return true;
    }

    private void feedPlayer(Player player) {
        player.setFoodLevel(20);
    }

}
