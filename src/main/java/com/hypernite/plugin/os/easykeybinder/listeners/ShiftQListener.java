package com.hypernite.plugin.os.easykeybinder.listeners;

import com.hypernite.plugin.os.easykeybinder.main.ConfigManager;
import com.hypernite.plugin.os.easykeybinder.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ShiftQListener implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if(player.isSneaking()) {
            if(ConfigManager.isShiftQEnable) {
                if(Utils.permissionChecker(player, Utils.qPermissionNode)) {
                    player.performCommand(ConfigManager.qCommand);
                } else {
                    player.sendMessage(ConfigManager.prefix + ConfigManager.permissonDeniedString);
                }
            }
        }
    }
}
