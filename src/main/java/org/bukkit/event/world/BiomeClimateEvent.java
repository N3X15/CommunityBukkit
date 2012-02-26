package org.bukkit.event.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class BiomeClimateEvent extends WorldEvent implements Cancellable {
    /**
     * 
     */
    private static final HandlerList handlers = new HandlerList();
    
    public enum ClimateType {
        TEMPERATURE,
        WETNESS
    }
    
    private final int x;
    private final int z;
    private final int rx;
    private final int rz;
    private final float[] climateData;
    private boolean cancelled = false;
    private final ClimateType climateType;
    
    public BiomeClimateEvent(ClimateType type, World world, int x, int z, int rx, int rz, float[] climatedata) {
        super(world);
        this.climateType = type;
        this.climateData = climatedata;
        this.x = x;
        this.z = z;
        this.rx = rx;
        this.rz = rz;
    }
    
    public Chunk getChunk() {
        return getWorld().getChunkAt(x >> 4, z >> 4);
    }
    
    public ClimateType getClimateType() {
        return climateType;
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
    
    public boolean isCancelled() {
        return cancelled;
    }
    
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    
    public float[] getClimateData() {
        return climateData;
    }
    
    public float getClimate(int x, int z) {
        return climateData[z + x * 16];
    }
    
    public void setClimate(int x, int z, float v) {
        climateData[z + x * 16] = v;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
