package me.cunzai.utils;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Back implements CommandExecutor {
    main javaPlugin;
    public Back(main javaPlugin){
        this.javaPlugin=javaPlugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("back")){
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player=(Player) sender;
                    if (javaPlugin.backListener.locationMap.get(player.getName())!=null) {
                        Location location = javaPlugin.backListener.locationMap.get(player.getName());
                        player.teleport(location);
                        player.sendMessage("§b已传送至死亡点");
                    }else {
                        player.sendMessage("未找到死亡点");
                    }
                }
            }
        }
        return true;
    }
}
