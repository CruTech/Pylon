package tech.cru.pylon.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;
import tech.cru.pylon.PylonMain;

import java.util.Random;

public class ServerListPing implements Listener {
    private PylonMain plugin = PylonMain.getInstance();

    @EventHandler (priority = EventPriority.HIGH)
    public void ServerListPing(ProxyPingEvent event) {
        ServerPing ping = event.getResponse();
        Random random = new Random();

        int get = random.nextInt(plugin.configurationManager.getMotd().getInt("motd.max"));
        String motd = ChatColor.translateAlternateColorCodes('&', plugin.configurationManager.getMotd().getString("motd." + get));
        ping.setDescription(motd);
        event.setResponse(ping);
    }
}