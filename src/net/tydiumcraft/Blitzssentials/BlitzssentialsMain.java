
package net.tydiumcraft.Blitzssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.Blitzssentials.commands.BroadcastAlert;
import net.tydiumcraft.Blitzssentials.commands.BroadcastServer;
import net.tydiumcraft.Blitzssentials.commands.Countdown;
import net.tydiumcraft.Blitzssentials.commands.Feed;
import net.tydiumcraft.Blitzssentials.commands.Fly;
import net.tydiumcraft.Blitzssentials.commands.GamemodeA;
import net.tydiumcraft.Blitzssentials.commands.GamemodeC;
import net.tydiumcraft.Blitzssentials.commands.GamemodeS;
import net.tydiumcraft.Blitzssentials.commands.GamemodeSP;
import net.tydiumcraft.Blitzssentials.commands.GodMode;
import net.tydiumcraft.Blitzssentials.commands.Heal;
import net.tydiumcraft.Blitzssentials.commands.Help;
import net.tydiumcraft.Blitzssentials.commands.HelpBC;
import net.tydiumcraft.Blitzssentials.commands.HelpGamemode;
import net.tydiumcraft.Blitzssentials.commands.HelpPlugin;
import net.tydiumcraft.Blitzssentials.commands.HelpTime;
import net.tydiumcraft.Blitzssentials.commands.HelpWeather;
import net.tydiumcraft.Blitzssentials.commands.KillAll;
import net.tydiumcraft.Blitzssentials.commands.MassSummon;
import net.tydiumcraft.Blitzssentials.commands.PluginCheckUpdate;
import net.tydiumcraft.Blitzssentials.commands.PluginInfo;
import net.tydiumcraft.Blitzssentials.commands.PluginConfig;
import net.tydiumcraft.Blitzssentials.commands.PluginReloadPlugin;
import net.tydiumcraft.Blitzssentials.commands.PluginTest;
import net.tydiumcraft.Blitzssentials.commands.PluginTestJoin;
import net.tydiumcraft.Blitzssentials.commands.PluginTestLeave;
import net.tydiumcraft.Blitzssentials.commands.Spawn;
import net.tydiumcraft.Blitzssentials.commands.TimeDay;
import net.tydiumcraft.Blitzssentials.commands.TimeMidnight;
import net.tydiumcraft.Blitzssentials.commands.TimeNight;
import net.tydiumcraft.Blitzssentials.commands.TimeNoon;
import net.tydiumcraft.Blitzssentials.commands.Vanish;
import net.tydiumcraft.Blitzssentials.commands.Weather;
import net.tydiumcraft.Blitzssentials.commands.WeatherClear;
import net.tydiumcraft.Blitzssentials.commands.WeatherRain;
import net.tydiumcraft.Blitzssentials.commands.WeatherThunder;
import net.tydiumcraft.Blitzssentials.commands.tpAll;
import net.tydiumcraft.Blitzssentials.commands.tpHere;
import net.tydiumcraft.Blitzssentials.events.JoinMessage;
import net.tydiumcraft.Blitzssentials.events.JoinPosition;
import net.tydiumcraft.Blitzssentials.events.LaunchPad;
import net.tydiumcraft.Blitzssentials.events.LeaveMessage;
import net.tydiumcraft.Blitzssentials.events.checkVersion;
import net.tydiumcraft.Blitzssentials.utils.ChatColors;
import net.tydiumcraft.Blitzssentials.utils.Metrics;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class BlitzssentialsMain extends JavaPlugin implements Listener {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String lastpluginversion = shortcutTags.lastpluginversion;
    String lastpluginversionquick = shortcutTags.lastpluginversionquick;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    String configversionS = shortcutTags.configversionS;
    int configversionI = shortcutTags.configversionI;
   
	@Override
	public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage(""
    			+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
				+ defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.GREEN + "|Plugin Enabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);

    	Vanish vanishclass = new Vanish();
    	JoinPosition joinpositionclass = new JoinPosition();
    	Countdown countdownclass = new Countdown();
    	
    	//BStats
    	 // All you have to do is adding the following two lines in your onEnable method.
         // You can find the plugin ids of your plugins on the page https://bstats.org/Blitzssentials
        int pluginId = 13142; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

         // Optional: Add custom charts
      //  metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
    	
    	//Config
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
    	
    	if (getConfig().getInt("config-version") == configversionI && getConfig().contains("config-version")) {
    		Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.GREEN + "Config is Up-to-Date!");
    	} else {
    		Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.RED + "Config is not Up-to-Date, use /BZSsConfig to Update it!");
    	}
    	
    	//Events/Utils
    	getServer().getPluginManager().registerEvents(new ChatColors(), this);
    	getServer().getPluginManager().registerEvents(new JoinMessage(), this);
    	getServer().getPluginManager().registerEvents(new JoinPosition(), this);
    	getServer().getPluginManager().registerEvents(new LeaveMessage(), this);
    	getServer().getPluginManager().registerEvents(new LaunchPad(), this);
    	
    	//checkVersion
    	String PluginUpdated = checkVersion.PluginUpdated;
    	String PluginOutdated = checkVersion.PluginOutdated;
    	String PluginError = checkVersion.VersionCheckError;
    	new checkVersion(this).getVersion(version -> {
            if (pluginversion.equalsIgnoreCase(version)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversion)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversionquick)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else {
            	Bukkit.getConsoleSender().sendMessage(PluginOutdated);
            }});

    	//Commands
    	new Help(this);
    	new HelpPlugin(this);
    	new HelpGamemode(this);
    	new HelpWeather(this);
    	new HelpTime(this);
    	new HelpBC(this);
    	
		new PluginTest(this);
		new PluginTestJoin(this);
		new PluginTestLeave(this);
		new PluginReloadPlugin(this);
		new PluginConfig(this);
		new PluginInfo(this);
		new PluginCheckUpdate(this);
		
		new MassSummon(this);
		
		new tpHere(this);
		new tpAll(this);
		new BroadcastServer(this);
		new BroadcastAlert(this);
		getCommand("countdown").setExecutor(countdownclass);
		getCommand("bccountdown").setExecutor(countdownclass);
		
		new Feed(this);
		new Heal(this);
		new Fly(this);
		new GodMode(this);
		new KillAll(this);
		
		new Spawn(this);
		
		getCommand("vanish").setExecutor(vanishclass);
		getCommand("unvanish").setExecutor(vanishclass);
		getCommand("togglevanish").setExecutor(vanishclass);
		
		getCommand("joinpos").setExecutor(joinpositionclass);
		
		new GamemodeC(this);
		new GamemodeS(this);
		new GamemodeSP(this);
		new GamemodeA(this);
		
		new TimeDay(this);
		new TimeNoon(this);
		new TimeNight(this);
		new TimeMidnight(this);
		
		new Weather(this);
		new WeatherClear(this);
		new WeatherRain(this);
		new WeatherThunder(this);
		
	}
	
	@Override
	public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage(""
    			+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
    			+ defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.RED + "|Plugin Disabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);
    	
    	saveDefaultConfig();
		
	}
}