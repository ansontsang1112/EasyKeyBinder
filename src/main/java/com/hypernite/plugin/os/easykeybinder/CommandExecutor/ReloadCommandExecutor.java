package com.hypernite.plugin.os.easykeybinder.CommandExecutor;

import com.hypernite.plugin.os.easykeybinder.Main.ConfigManager;
import com.hypernite.plugin.os.easykeybinder.Main.EasyKeyBinder;
import com.hypernite.plugin.os.easykeybinder.Main.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String permission = "ekb.admin";

        if(!Utils.permissionChecker((Player) sender, permission)) {
            sender.sendMessage("EKB | Permission Denied");
            return false;
        }

        if(args[0].equalsIgnoreCase("reload")) {
            ConfigManager.getInstance(EasyKeyBinder.plugin).reloadConfig();
            sender.sendMessage("EKB | Configuration Successfully reloaded");
        }

        return false;
    }
}
