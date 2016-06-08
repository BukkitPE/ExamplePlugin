package ExamplePlugin;

import net.BukkitPE.event.EventHandler;
import net.BukkitPE.event.EventPriority;
import net.BukkitPE.event.Listener;
import net.BukkitPE.event.server.ServerCommandEvent;

/**
 * author: BukkitPE Team
 * NukkitExamplePlugin Project
 */
public class EventListener implements Listener {
    MainClass plugin;

    public EventListener(MainClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //DON'T FORGET THE ANNOTATION @EventHandler
    public void onServerCommand(ServerCommandEvent event) {
        this.plugin.getLogger().info("ServerCommandEvent is called!");
        //you can do more here!
    }
}
