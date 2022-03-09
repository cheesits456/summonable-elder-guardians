package com.cheesits456.summonableelderguardians.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;

public class BlockPlace implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block placed = event.getBlockPlaced();
        World world = placed.getWorld();

        if (placed.getType() == Material.GOLD_BLOCK) {

            int x = placed.getX();
            int y = placed.getY();
            int z = placed.getZ();
            boolean[] valid = {true, true, true};
            int[][][] blocks = {
                    {{0, -1, -1}, {0, 0, -1}, {0, 1, -1}, {0, -1, 0}, {0, 1, 0}, {0, -1, 1}, {0, 0, 1}, {0, 1, 1}},
                    {{-1, 0, -1}, {0, 0, -1}, {1, 0, -1}, {-1, 0, 0}, {1, 0, 0}, {-1, 0, 1}, {0, 0, 1}, {1, 0, 1}},
                    {{-1, -1, 0}, {0, -1, 0}, {1, -1, 0}, {-1, 0, 0}, {1, 0, 0}, {-1, 1, 0}, {0, 1, 0}, {1, 1, 0}}
            };
            for (int i = 0; i < 3; i++) {
                for (int[] a : blocks[i]) {
                    if (world.getBlockAt(x + a[0], y + a[1], z + a[2]).getType() != Material.PRISMARINE_BRICKS)
                        valid[i] = false;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (valid[i]) {
                    placed.setType(Material.AIR);
                    for (int[] a : blocks[i]) {
                        world.getBlockAt(x + a[0], y + a[1], z + a[2]).setType(Material.AIR);
                    }
                    Location loc = new Location(world, x + 0.5, y + 0.5, z + 0.5);
                    world.spawnEntity(loc, EntityType.ELDER_GUARDIAN);
                }
            }

            // if (world.getBlockAt(x, y - 1, z).getType() == Material.DIAMOND_BLOCK) {
            // 	if ((world.getBlockAt(x, y - 2, z + 1).getType() == Material.DIAMOND_BLOCK
            // 			&& world.getBlockAt(x, y - 2, z - 1).getType() == Material.DIAMOND_BLOCK)
            // 			|| (world.getBlockAt(x + 1, y - 2, z).getType() == Material.DIAMOND_BLOCK
            // 					&& world.getBlockAt(x - 1, y - 2, z).getType() == Material.DIAMOND_BLOCK)) {
            // 		Location loc = new Location(world, x + 0.5, y + 0.5, z + 0.5);
            // 		Firework fw = (Firework) world.spawnEntity(loc, EntityType.FIREWORK);
            // 	}
            // } else
            // 	return;


        }
    }
}
