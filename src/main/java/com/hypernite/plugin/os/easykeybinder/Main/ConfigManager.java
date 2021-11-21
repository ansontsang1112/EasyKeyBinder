package com.hypernite.plugin.os.easykeybinder.Main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    public static boolean isShiftFEnable, isShiftQEnable;
    public static String fCommand, qCommand, fSender, qSender;

    private static ConfigManager configManager;
    private File configFile;
    private FileConfiguration fileConfiguration;


    private ConfigManager(Plugin plugin) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists()) {
            plugin.saveResource("config.yml", true);
            fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        }
    }

    public static ConfigManager getInstance(Plugin plugin) {
        if(configManager == null) {
            configManager = new ConfigManager(plugin);
        }
        return configManager;
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public void loadConfig() {
        isShiftFEnable = fileConfiguration.getBoolean("binding.shiftF.enable");
        isShiftQEnable = fileConfiguration.getBoolean("binding.shiftQ.enable");

        fCommand = fileConfiguration.getString("binding.shiftF.command");
        qCommand = fileConfiguration.getString("binding.shiftQ.command");

        fSender = fileConfiguration.getString("binding.shiftF.sender");
        qSender = fileConfiguration.getString("binding.shiftQ.sender");
    }

    public void reloadConfig() {
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        loadConfig();
    }
}
