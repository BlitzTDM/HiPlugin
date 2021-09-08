package net.tydiumcraft.HiPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.HiPlugin.Main;

public class HiCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	
	public HelloCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("Hi").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players may execute this command!");
			return true;
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("hi.use")) {
			p.sendMessage(ChatColor.GREEN + "Hi!");
			return true;
		} else { 
			p.sendMessage(ChatColor.RED + "No Permission!");	
		}		
			return false;
	}
}
