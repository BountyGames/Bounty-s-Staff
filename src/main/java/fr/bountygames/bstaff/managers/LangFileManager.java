package fr.bountygames.bstaff.managers;

import fr.bountygames.bstaff.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LangFileManager {

    private static Main plugin;
    private static FileConfiguration langConfig;

    public LangFileManager(Main plugin) {
        LangFileManager.plugin = plugin;
    }

    public static boolean languageExists(String language) {
        return plugin.getResource("lang/" + language + ".yml") == null;
    }

    public static void createLanguage() {
        for(String language : plugin.getConfig().getStringList("langs")) {
            File langFile = new File(plugin.getDataFolder(), "lang/" + language + ".yml");
            if(!langFile.getParentFile().exists()) {
                langFile.getParentFile().mkdirs();
            }
            if(!langFile.exists()) {
                plugin.saveResource("lang/" + language + ".yml", false);
                plugin.getLogger().info("Language " + language + " created");
            }
        }
    }

    public static void loadLanguage(String language) {
        String lang = plugin.getLang();
        File langFile = new File(plugin.getDataFolder(), "lang/" + lang + ".yml");
        langConfig = YamlConfiguration.loadConfiguration(langFile);
    }

    public FileConfiguration getLangConfig() {
        return langConfig;
    }

}
