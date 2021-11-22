package com.hypernite.plugin.os.easykeybinder.listeners;

import com.hypernite.plugin.os.easykeybinder.main.ConfigManager;
import com.hypernite.plugin.os.easykeybinder.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class ShiftFListener implements Listener {

    @EventHandler
    public void onPlayerSwapItem(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        if(player.isSneaking()) {
            if(ConfigManager.isShiftFEnable) {
                if(Utils.permissionChecker(player, Utils.fPermissionNode)) {
                    player.performCommand(ConfigManager.fCommand);
                } else {
                    player.sendMessage(ConfigManager.prefix + ConfigManager.permissonDeniedString);
                }
            }
        }
    }
}
