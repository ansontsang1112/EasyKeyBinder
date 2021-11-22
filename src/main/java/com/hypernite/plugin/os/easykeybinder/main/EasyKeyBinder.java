package com.hypernite.plugin.os.easykeybinder.main;

import com.hypernite.plugin.os.easykeybinder.commandExecutors.ReloadCommandExecutor;
import com.hypernite.plugin.os.easykeybinder.listeners.ShiftFListener;
import com.hypernite.plugin.os.easykeybinder.listeners.ShiftQListener;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyKeyBinder extends JavaPlugin {
    public static Plugin plugin;
    public static ConsoleCommandSender consoleCommandSender;

    @Override
    public void onEnable() {
        //Globally used vars
        plugin = this;
        consoleCommandSender = this.getServer().getConsoleSender();

        //Config Management
        ConfigManager.getInstance(this).loadConfig();

        //Enable Listeners and Commands
        this.getServer().getPluginManager().registerEvents(new ShiftFListener(), this);
        this.getServer().getPluginManager().registerEvents(new ShiftQListener(), this);
        this.getCommand("ekb-reload").setExecutor(new ReloadCommandExecutor());

        this.getLogger().info(ChatColor.BLUE + "[EasyKeyboardBinder] " + ChatColor.GREEN + " EasyKeyBinder loaded successfully");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.BLUE + "[EasyKeyboardBinder] " + ChatColor.RED + "EasyKeyBinder disabled successfully");
    }
}
