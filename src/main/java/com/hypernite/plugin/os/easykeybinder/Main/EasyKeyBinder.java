package com.hypernite.plugin.os.easykeybinder.Main;

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

        this.getLogger().info("EKB | EasyKeyBinder loaded successfully");

    }

    @Override
    public void onDisable() {
        this.getLogger().info("EKB | EasyKeyBinder disabled successfully");
    }
}
