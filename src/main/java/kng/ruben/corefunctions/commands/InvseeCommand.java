package kng.ruben.corefunctions.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command is only for players.");
            return false;
        }

        if (args.length == 1) {
            var target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage("§cThis player is not online, so you cannot see his inventory.");
                return false;
            }

            if (target != player)
                player.openInventory(target.getInventory());
            else
                player.sendMessage("§cThis is not possible.");
        } else
            player.sendMessage("§cPlease use /invsee <player>");

        return true;
    }

}
