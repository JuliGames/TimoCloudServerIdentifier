package net.juligames.core.addons.timocloudidentifier.velocity;

import cloud.timo.TimoCloud.api.TimoCloudAPI;
import cloud.timo.TimoCloud.api.objects.ProxyObject;
import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import net.juligames.core.Core;
import org.slf4j.Logger;

@Plugin(
        id = "timocloudvelocityidentifier",
        name = "TimoCloudVelocityIdentifier",
        version = "1.0-SNAPSHOT",
        authors = "Ture Bentzin",
        dependencies = {
                @Dependency(id = "velocitycore"),
                @Dependency(id = "timocloud")
        }
)
public class TimoCloudVelocityIdentifier {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // Plugin startup logic
        ProxyObject thisServer = TimoCloudAPI.getProxyAPI().getThisProxy();
        String name = thisServer.getName();
        Core.getInstance().getClusterApi().identify(name);
        logger.info("Server was identified as: " + name);
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        Core.getInstance().getClusterApi().identify(null);
        logger.info("Server was identification was removed");
    }


}
