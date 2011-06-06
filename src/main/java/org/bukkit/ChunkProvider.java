package org.bukkit;

import org.bukkit.block.Biome;

/**
 * Creates chunks and stuff.
 * @author Rob
 *
 */
public abstract class ChunkProvider {

	private boolean _hasCustomTerrain=false;
	private boolean _hasCustomPopulator=false;
	private boolean _hasCustomCaves=false;
	private boolean _hasCustomSedimenter=false;
	
	/**
	 * Set up the ChunkProvider
	 * 
	 * @param world
	 * @param seed
	 */
	public abstract void onLoad(Object world, long seed);

	/**
	 * Set to true to define a custom generateChunk().
	 * @param yes
	 */
	public void setHasCustomTerrain(boolean yes) { this._hasCustomTerrain=yes; }
	public final boolean hasCustomTerrain() { return this._hasCustomTerrain; }

	/**
	 * Set to true to define a custom populateChunk().
	 * @param yes
	 */
	public void setHasCustomPopulator(boolean yes) { _hasCustomPopulator=yes; }
	public final boolean hasCustomPopulator() { return _hasCustomPopulator; }

	/**
	 * Set to true to define a custom cave generator.
	 * @param yes
	 */
	public void setHasCustomCaves(boolean yes) { _hasCustomCaves=yes; }
	public final boolean hasCustomCaves() { return _hasCustomCaves; }
	
	/**
	 * Set to true to define a custom sediment generator.
	 * @param yes
	 */
	public void setHasCustomSedimenter(boolean yes) { _hasCustomSedimenter=yes; }
	public final boolean hasCustomSedimenter() { return _hasCustomSedimenter; }

	/**
	 * Handle the creation of caves by setting blocks.
	 *  (DO NOT USE WORLD FUNCTIONS TO SET BLOCK MATERIALS OR DATA)
	 * @param world
	 * @param x
	 * @param z
	 * @param blocks
	 */
	public void generateCaves(World world, int x, int z, byte[][][] blocks) {}

	/**
	 * Generate a chunk's terrain and water.
	 * (DO NOT USE WORLD FUNCTIONS TO SET BLOCK MATERIALS OR DATA)
	 * @param world
	 * @param x
	 * @param z
	 * @param blocks
	 * @param biomes
	 * @param temperature
	 */
	public void generateChunk(World world, int x, int z, byte[][][] blocks,
			Biome[][] biomes, double[][] temperature) {}

	/**
	 * Generate sediment (dirt, gravel, sand)
	 *  (DO NOT USE WORLD FUNCTIONS TO SET BLOCK MATERIALS OR DATA)
	 * @param world
	 * @param x
	 * @param z
	 * @param blocks
	 * @param biomes
	 */
	public void generateSediment(World world, int x, int z, byte[][][] blocks,
			Biome[][] biomes) {}

	/**
	 * Populate a chunk (flowers, trees, ores, etc.)
	 * @param world
	 * @param x
	 * @param z
	 */
	public void populateChunk(World world, int x, int z) {}
	
	/**
	 * Determine whether the user can spawn at this column.
	 * @param world
	 * @param x
	 * @param z
	 * @return
	 */
	public boolean canSpawnAt(World world,int x, int z) {return false;}
}
