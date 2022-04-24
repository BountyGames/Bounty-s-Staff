package fr.bountygames.bstaff.cmd.tab;

import fr.bountygames.bstaff.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class StaffTabCompleter implements TabCompleter {
    public StaffTabCompleter(Main plugin) {
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
