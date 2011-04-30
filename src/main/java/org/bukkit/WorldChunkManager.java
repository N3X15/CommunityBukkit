package org.bukkit;

import org.bukkit.block.Biome;

public abstract class WorldChunkManager {

    public double[] temperatures;
	public double[] humidity;
	public double[] field_c;

	protected WorldChunkManager() {
	}
    public WorldChunkManager(World world) {
	}

    public Biome getBiomeAt(int x, int z) {
        return this.getBiomes(x, z, 1, 1)[0];
    }

    public abstract Biome[] getBiomes(int x, int z, int h, int w);

    public abstract double[] genBiomes(double[] adouble, int x, int z, int h, int w);

    public abstract Biome[] genBiomes(Biome[] abiomebase, int x, int z, int h, int w);
    
	public boolean canSpawnAt(int x, int z) {
		return true;
	}
}
