package com.gmail.megagamer410.smeltdown;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of plugin.
 */
public class Smeltdown extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new InteractListener(this), this);
		getLogger().info("Smeltdown enabled!");
	}

	@Override
	public void onDisable() {
		
	}
}
