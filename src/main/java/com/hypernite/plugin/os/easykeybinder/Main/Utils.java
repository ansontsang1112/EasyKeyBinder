package com.hypernite.plugin.os.easykeybinder.Main;

import org.bukkit.entity.Player;

public class Utils {
    public static boolean permissionChecker(Player player, String permission) {
        if(player.hasPermission(permission)) {
            return true;
        } else {
            return false;
        }
    }
}
