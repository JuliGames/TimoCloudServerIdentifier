package net.juligames.core.addons.timocloudidentifier.paper;

import cloud.timo.TimoCloud.api.TimoCloudAPI;
import cloud.timo.TimoCloud.api.objects.ServerObject;
import net.juligames.core.Core;
import org.bukkit.plugin.java.JavaPlugin;

public final class TimoCloudPaperIdentifier extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ServerObject thisServer = TimoCloudAPI.getBukkitAPI().getThisServer();
        String name = thisServer.getName();
        Core.getInstance().getClusterApi().identify(name);
        getLogger().info("Server was identified as: " + name);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Core.getInstance().getClusterApi().identify(null);
        getLogger().info("Server was identification was removed");
    }
}
