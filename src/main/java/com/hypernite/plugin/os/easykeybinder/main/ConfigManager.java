package com.hypernite.plugin.os.easykeybinder.main;

import com.hypernite.plugin.os.easykeybinder.utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    public static boolean isShiftFEnable, isShiftQEnable, isShiftFPermission, isShiftQPermission;
    public static String fCommand, qCommand, permissonDeniedString, prefix, reloadString;

    private static ConfigManager configManager;
    private File configFile;
    private FileConfiguration fileConfiguration;


    private ConfigManager(Plugin plugin) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists()) {
            plugin.saveResource("config.yml", true);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public static ConfigManager getInstance(Plugin plugin) {
        if(configManager == null) {
            configManager = new ConfigManager(plugin);
        }
        return configManager;
    }

    public void loadConfig() {
        isShiftFEnable = fileConfiguration.getBoolean("binding.shiftF.enable");
        isShiftQEnable = fileConfiguration.getBoolean("binding.shiftQ.enable");

        fCommand = fileConfiguration.getString("binding.shiftF.command");
        qCommand = fileConfiguration.getString("binding.shiftQ.command");

        isShiftFPermission = fileConfiguration.getBoolean("binding.shiftF.permission");
        isShiftQPermission = fileConfiguration.getBoolean("binding.shiftQ.permission");

        prefix = Utils.colorReplacer(fileConfiguration.getString("lang.prefix"));
        permissonDeniedString = Utils.colorReplacer(fileConfiguration.getString("lang.permission-denied"));
        reloadString = Utils.colorReplacer(fileConfiguration.getString("lang.reload"));
    }

    public void reloadConfig() {
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        loadConfig();
    }
}
