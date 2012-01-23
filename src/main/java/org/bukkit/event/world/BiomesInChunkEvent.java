/**
 * 
 */
package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Rob
 * 
 */
public class BiomesInChunkEvent extends Event implements Cancellable {
    
    /**
     * 
     */
    private static final HandlerList handlers = new HandlerList();
    private static final long serialVersionUID = 233532555114423982L;
    private final World world;
    private Biome[] biomes;
    private boolean cancelled = false;
    private final int x;
    private final int z;
    private final int rx;
    private final int rz;
    
    public BiomesInChunkEvent(World world, int x, int z, int rx, int rz, Biome[] biomes) {
        super(Type.BIOME_GENERATE);
        this.biomes = biomes;
        this.world = world;
        this.x = x;
        this.z = z;
        this.rx = rx;
        this.rz = rz;
    }
    
    public World getWorld() {
        return world;
    }
    
    public Chunk getChunk() {
        return world.getChunkAt(x >> 4, z >> 4);
    }
    
    public int getX() {
        return x;
    }
    
    public int getZ() {
        return z;
    }
    
    public int getRangeX() {
        return rx;
    }
    
    public int getRangeZ() {
        return rz;
    }
    
    public Biome[] getBiomes() {
        return biomes;
    }
    
    public void setBiomes(Biome[] biomes) {
        this.biomes = biomes;
    }
    
    public boolean isCancelled() {
        return cancelled;
    }
    
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    
    public Biome getBiome(int x, int z) {
        return biomes[z + x * 16];
    }
    
    public void setBiome(int x, int z, Biome v) {
        biomes[z + x * 16] = v;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
