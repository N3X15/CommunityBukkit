package org.bukkit;

import org.bukkit.block.Biome;

public abstract class ChunkProvider {

	/**
	 * Set up the ChunkProvider
	 * 
	 * @param world
	 * @param seed
	 */
	public abstract void onLoad(World world, long seed);

	public abstract boolean hasCustomTerrainGenerator();

	public abstract boolean hasCustomPopulator();

	public abstract boolean hasCustomCaves();

	public abstract void generateCaves(World world, int x, int z, byte[] abyte);

	public abstract void generateChunk(World world, int x, int z, byte[] abyte,
			Biome[] biomes, double[] temperature);

	public abstract void populateChunk(World world, int x, int z, byte[] abyte,
			Biome[] biomes);

}
