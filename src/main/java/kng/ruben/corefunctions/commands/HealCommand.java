package kng.ruben.corefunctions.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command is only for players.");
            return false;
        }

        if (args.length == 0) {
            healPlayer(player);
            player.sendMessage("§aYou successfully healed yourself.");

            return true;
        }
        var target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cThis player is not online, so you cannot heal him.");
            return false;
        } else if (target == player) {
            healPlayer(player);
            player.sendMessage("§aYou successfully healed yourself.");
            return true;
        }
        healPlayer(target);

        player.sendMessage("§aYou successfully healed " + target.getName() + ".");
        target.sendMessage("§aYou got healed by " + player.getName() + ".");

        return true;
    }

    private void healPlayer(Player player) {
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
    }

}
