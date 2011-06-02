package org.bukkit;

import org.bukkit.block.Biome;

public abstract class ChunkProvider {

	private boolean _hasCustomTerrain=false;
	private boolean _hasCustomPopulator=false;
	private boolean _hasCustomCaves=false;
	private boolean _hasCustomSedimenter=false;

	public int getBlockIndex(int x, int y, int z) {
        return x << 11 | z << 7 | y;
	}
	
	/**
	 * Set up the ChunkProvider
	 * 
	 * @param world
	 * @param seed
	 */
	public abstract void onLoad(Object world, long seed);

	public void setHasCustomTerrain(boolean yes) { this._hasCustomTerrain=yes; }
	public final boolean hasCustomTerrain() { return this._hasCustomTerrain; }

	public void setHasCustomPopulator(boolean yes) { _hasCustomPopulator=yes; }
	public final boolean hasCustomPopulator() { return _hasCustomPopulator; }

	public void setHasCustomCaves(boolean yes) { _hasCustomCaves=yes; }
	public final boolean hasCustomCaves() { return _hasCustomCaves; }
	
	public void setHasCustomSedimenter(boolean yes) { _hasCustomSedimenter=yes; }
	public final boolean hasCustomSedimenter() { return _hasCustomSedimenter; }

	public void generateCaves(World world, int x, int z, byte[][][] blocks) {}

	public void generateChunk(World world, int x, int z, byte[][][] blocks,
			Biome[][] biomes, double[][] temperature) {}

	public void generateSediment(World world, int x, int z, byte[][][] blocks,
			Biome[][] biomes) {}

	public void populateChunk(World world, int x, int z) {}
	
	public boolean canSpawnAt(World w,int x, int z) {return false;}
}
