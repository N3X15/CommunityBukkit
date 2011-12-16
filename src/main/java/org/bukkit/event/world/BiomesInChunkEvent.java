/**
 * 
 */
package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * @author Rob
 * 
 */
public class BiomesInChunkEvent extends Event implements Cancellable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 233532555114423982L;
    private World world;
    private Biome[] biomes;
    private boolean cancelled=false;
    private int x;
    private int z;
    private int rx;
    private int rz;
    
    public BiomesInChunkEvent(World world, int x, int z, int rx, int rz,
            Biome[] biomes) {
        super(Type.BIOME_GENERATE);
        this.biomes=biomes;
        this.world=world;
        this.x=x;
        this.z=z;
        this.rx=rx;
        this.rz=rz;
    }

    public World getWorld() {
        return world;
    }
    
    public Chunk getChunk() {
        return world.getChunkAt(x>>4,z>>4);
    }

    public int getX() { return x; }
    public int getZ() { return z; }
    public int getRangeX() { return rx; }
    public int getRangeZ() { return rz; }
    
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
        cancelled=cancel;
    }
    
}
