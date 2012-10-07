package com.gmail.megagamer410.smeltdown;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Smeltdown extends JavaPlugin
{
	static ConcurrentHashMap<String, Long> pumpMap = new ConcurrentHashMap<String, Long>();
	Logger log;
	public void onEnable()
	{
		log = this.getLogger();
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new InteractListener(this), this);
		log.info("Smeltdown enabled!");
	}
	
	public void onDisable()
	{
		
	}
}
