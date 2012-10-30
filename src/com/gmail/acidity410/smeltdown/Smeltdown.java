/*
    Copyright (C) 2012  Tyler O'Meara
    Email: OMeara.Tyler@gmail.com

    This file is part of Smeltdown.

    Smeltdown is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Smeltdown is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Smeltdown.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.gmail.acidity410.smeltdown;

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
