package com.hypernite.plugin.os.easykeybinder.commandExecutors;

import com.hypernite.plugin.os.easykeybinder.main.ConfigManager;
import com.hypernite.plugin.os.easykeybinder.main.EasyKeyBinder;
import com.hypernite.plugin.os.easykeybinder.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String permission = "ekb.admin";

        if(!Utils.permissionChecker((Player) sender, permission)) {
            sender.sendMessage(ConfigManager.prefix + ConfigManager.permissonDeniedString);
            return false;
        }

        ConfigManager.getInstance(EasyKeyBinder.plugin).reloadConfig();
        sender.sendMessage(ConfigManager.prefix + ConfigManager.reloadString);

        return false;
    }
}
