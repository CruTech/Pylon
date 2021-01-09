package tech.cru.pylon.commands.servers;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class xprace extends Command {
    public xprace() {
        super("xprace");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;

            // Check if the Player is already connected to the Hub
            if (player.getServer().getInfo().getName().equalsIgnoreCase("xprace")) {
                player.sendMessage(new TextComponent(ChatColor.RED + "You are already connected to XP Race!"));
                return;
            } else {
                if (player.hasPermission("bungeecord.server.xprace")) {
                    ServerInfo target = ProxyServer.getInstance().getServerInfo("xprace");
                    player.connect(target);
                } else {
                    player.sendMessage(new TextComponent(ChatColor.RED + "You do not have access to this server."));
                }
            }
            return;
        }
    }
}
