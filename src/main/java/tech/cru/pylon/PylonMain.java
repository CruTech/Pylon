package tech.cru.pylon;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import tech.cru.pylon.commands.servers.*;
import tech.cru.pylon.events.PlayerChatEvent;
import tech.cru.pylon.events.ServerListPing;

public class PylonMain extends Plugin implements Listener {
    private static PylonMain plugin;
    public static ConfigurationManager configurationManager;

    @Override
    public void onEnable() {
        setInstance(this);
        configurationManager.initConfig(); // Create and load config.yml
        configurationManager.initFilter(); // Create and load filter.yml
        configurationManager.initMotd(); // Create and load motd.yml

        // Servers
        getProxy().getPluginManager().registerCommand(this, new hub());
        getProxy().getPluginManager().registerCommand(this, new creative());
        getProxy().getPluginManager().registerCommand(this, new survival());
        getProxy().getPluginManager().registerCommand(this, new mixed());
        getProxy().getPluginManager().registerCommand(this, new xprace());

        // Event Registry
        getProxy().getPluginManager().registerListener(this, new ServerListPing());
        getProxy().getPluginManager().registerListener(this, new PlayerChatEvent());
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.translateAlternateColorCodes('&', Variables.developmentprefix + ChatColor.BLUE + " Shutting down..."));
    }

    public static PylonMain getInstance() {
        return plugin;
    }

    private static void setInstance(PylonMain instance) {
        PylonMain.plugin = instance;
    }
}
