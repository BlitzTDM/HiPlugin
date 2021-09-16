package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class GamemodeS implements CommandExecutor {
	
	public String line = "------------------------------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD";
	private BlitzssentialsMain plugin;
	
	public GamemodeS(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gms").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	if (sender instanceof Player) {
    		Player p = (Player) sender;
    		if (p.hasPermission("BlitzSsentials.gms")) {
    			if (((Player) sender).getGameMode() == GameMode.SURVIVAL) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    			((Player) sender).setGameMode(GameMode.SURVIVAL);
    				}
    		} else {
    				p.sendMessage(noperm);
    			}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(console);
    	}
		return false;
    }
}
