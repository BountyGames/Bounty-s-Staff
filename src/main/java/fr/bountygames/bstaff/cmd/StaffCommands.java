package fr.bountygames.bstaff.cmd;

import fr.bountygames.bstaff.Main;
import fr.bountygames.bstaff.cmd.tab.StaffTabCompleter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class StaffCommands implements CommandExecutor {

    Main plugin;

    public StaffCommands(Main main) {
        this.plugin = main;
        Objects.requireNonNull(plugin.getCommand("staff")).setExecutor(this);
        Objects.requireNonNull(plugin.getCommand("staff")).setTabCompleter(new StaffTabCompleter(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("bstaff.staff")) {
            if(args.length == 0) {
                sender.sendMessage("§2======== §eBStaff §2========");
                sender.sendMessage("§e/staff §7- §fAffiche les commandes du staff");
                sender.sendMessage("§2======== §eBStaff §2========");
            } else {
                switch(args[0]) {
                    case "reload":
                        if(sender.hasPermission("bstaff.staff.reload")) {
                            plugin.reloadConfig();
                        } else {
                            //Permission message
                        }
                        break;
                    case "freeze":
                        if(sender.hasPermission("bstaff.staff.freeze")) {
                            if(args.length == 2) {
                                if(plugin.getServer().getPlayer(args[1]) != null) {
                                    plugin.getServer().getPlayer(args[1]).setWalkSpeed(0);
                                    plugin.getServer().getPlayer(args[1]).setFlySpeed(0);
                                    plugin.getServer().getPlayer(args[1]).setAllowFlight(true);
                                    //Player has been frozen
                                    //Say to player that he has been frozen
                                } else {
                                    //Player not found message
                                }
                            } else {
                        } else {
                            //Permission message
                        }
                        break;
                    case "unfreeze":
                        if(sender.hasPermission("bstaff.staff.unfreeze")) {
                            if(args.length == 2) {
                                if(plugin.getServer().getPlayer(args[1]) != null) {
                                    plugin.getServer().getPlayer(args[1]).setWalkSpeed(0.2F);
                                    plugin.getServer().getPlayer(args[1]).setFlySpeed(0.2F);
                                    plugin.getServer().getPlayer(args[1]).setAllowFlight(false);
                                    //Player has been unfrozen
                                    //Say to player that he has been unfrozen
                                } else {
                                    //Player not found message
                                }
                            } else {
                                //Missing argument message (Player)
                            }
                        } else {
                            //Permission message
                        }
                    default:
                        //Message command doesn't exist
                        break;
                }
            }
        }
        return false;
    }
}
