package com.gmail.megagamer410.smeltdown;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener 
{
	/**
	 * Necessary to get the server on static methods.
	 */
	
	static Smeltdown Plugin;
	
	/**
	 * Passes the Smeltdown instance for static methods.
	 * @param plugin Smeltdown plugin being passed in.
	 */
	
	public InteractListener(Smeltdown plugin) 
	{
		Plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.getAction().name().equalsIgnoreCase("LEFT_CLICK_BLOCK")) {
			if(event.getClickedBlock() != null) {
				if(event.getClickedBlock().getType() != null) {
					if(event.getClickedBlock().getType() == Material.FURNACE && ((Furnace)event.getClickedBlock().getState()).getInventory().getSmelting() != null && ((Furnace)event.getClickedBlock().getState()).getInventory().getFuel() != null) {
						if(((Furnace)event.getClickedBlock().getState()).getInventory().getFuel().getType() == Material.COAL) {
							if(Plugin.getConfig().getConfigurationSection("Materials").getKeys(true).contains(((Furnace)event.getClickedBlock().getState()).getInventory().getSmelting().getType().toString())) {
								Furnace furnace = ((Furnace)event.getClickedBlock().getState());
								int maxDurability = furnace.getInventory().getSmelting().getType().getMaxDurability();
								int remainingDurability = maxDurability - furnace.getInventory().getSmelting().getDurability();
								int baseMaterial =  Plugin.getConfig().getInt(("Materials."+furnace.getInventory().getSmelting().getType().toString()));
								int requiredFuel = (int)((double)remainingDurability / (double)maxDurability * (double)baseMaterial);
								if(requiredFuel <= 0) {
									event.getPlayer().sendMessage("§f[§3Smeltdown§f]§b This tool is too damaged to smelt.");
								} else if(furnace.getInventory().getResult() != null) {
									event.getPlayer().sendMessage("§f[§3Smeltdown§f]§b You must remove all the resultant items from the furnace.");
								} else if(furnace.getInventory().getFuel().getAmount() >= requiredFuel) {
									ItemStack newFuel = furnace.getInventory().getFuel();
									newFuel.setAmount(furnace.getInventory().getFuel().getAmount()-requiredFuel);
									furnace.getInventory().setFuel(newFuel);
									if(furnace.getInventory().getSmelting().getType().toString().contains("DIAMOND")) {
										furnace.getInventory().setResult(new ItemStack(Material.DIAMOND,requiredFuel));
									}
									if(furnace.getInventory().getSmelting().getType().toString().contains("IRON")) {
										furnace.getInventory().setResult(new ItemStack(Material.IRON_INGOT,requiredFuel));
									}
									if(furnace.getInventory().getSmelting().getType().toString().contains("GOLD")) {
										furnace.getInventory().setResult(new ItemStack(Material.GOLD_INGOT,requiredFuel));
									}
									furnace.getInventory().clear(0);
								}
							}
						}
					}
				}
			}
		}
	}
}
