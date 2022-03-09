package com.cheesits456.summonableelderguardians;

import org.bukkit.plugin.java.JavaPlugin;

// Import events
import com.cheesits456.summonableelderguardians.events.BlockPlace;

public class App extends JavaPlugin {
	@Override
	public void onEnable() {
		// Load events
		getLogger().info("Loading Events . . .");
		getServer().getPluginManager().registerEvents(new BlockPlace(), this);

		getLogger().info("Done!");
	}

	@Override
	public void onDisable() {
	}
}