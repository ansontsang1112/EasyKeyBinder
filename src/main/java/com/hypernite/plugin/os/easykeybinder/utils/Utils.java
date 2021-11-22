package com.hypernite.plugin.os.easykeybinder.utils;

import org.bukkit.entity.Player;

public class Utils {
    public static String fPermissionNode = "ekb.shift.f";
    public static String qPermissionNode = "ekb.shift.q";

    public static boolean permissionChecker(Player player, String permission) {
        if(player.hasPermission(permission)) {
            return true;
        } else {
            return false;
        }
    }

    public static String colorReplacer(String string) {
        if(string.contains("&")) {
            string = string.replace("&", "§");
        }
        return string;
    }
}
