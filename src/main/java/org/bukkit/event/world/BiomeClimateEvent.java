package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.event.Cancellable;

public class BiomeClimateEvent extends WorldEvent implements Cancellable {
    /**
     * 
     */
    private static final long serialVersionUID = 1912052838696287046L;

    public enum ClimateType {
        TEMPERATURE,
        WETNESS
    }

    private int x;
    private int z;
    private int rx;
    private int rz;
    private float[] climatedata;
    private boolean cancelled=false;
    public BiomeClimateEvent(ClimateType temperature, World world, int x,
            int z, int rx, int rz, float[] climatedata) {
        super(Type.BIOME_CLIMATE, world);
        this.climatedata=climatedata;
        this.x=x;
        this.z=z;
        this.rx=rx;
        this.rz=rz;
    }
    
    public Chunk getChunk() {
        return getWorld().getChunkAt(x>>4,z>>4);
    }

    public int getX() { return x; }
    public int getZ() { return z; }
    public int getRangeX() { return rx; }
    public int getRangeZ() { return rz; }

    public boolean isCancelled() {
        return cancelled;
    }
    
    public void setCancelled(boolean cancel) {
        cancelled=cancel;
    }

    public float[] getClimateData() {
        // TODO Auto-generated method stub
        return climatedata;
    }
    
}
