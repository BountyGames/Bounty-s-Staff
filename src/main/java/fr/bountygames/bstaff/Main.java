package fr.bountygames.bstaff;

import fr.bountygames.bstaff.cmd.StaffCommands;
import org.bukkit.plugin.java.JavaPlugin;

import static fr.bountygames.bstaff.managers.LangFileManager.*;

public final class Main extends JavaPlugin {

    private final String lang = getConfig().getString("lang");

    @Override
    public void onEnable() {
        // Plugin startup
        saveDefaultConfig();
        createLanguage();

        if(languageExists(lang)) {
            getLogger().severe("Language " + lang + " doesn't exist");
            getLogger().severe("Disabling plugin");
            getServer().getPluginManager().disablePlugin(this);
        } else {
            loadLanguage(lang);
        }

        // Register commands
        new StaffCommands(this);

        getLogger().info("Plugin enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String getLang() {
        return lang;
    }
}
