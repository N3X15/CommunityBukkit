package org.bukkit;

import org.bukkit.block.Biome;

public abstract class ChunkProvider {

	/**
	 * Set up the ChunkProvider
	 * @param world
	 * @param seed
	 */
	public abstract void onLoad(World world, long seed);

	public abstract void generateChunk(int x, int z, byte[] abyte, Biome[] biomes,
			double[] temperature);

	public abstract void populateChunk(int x, int z, byte[] abyte,
			Biome[] biomes);

	public boolean hasCustomTerrainGenerator() {
		return false;
	}

	public boolean hasCustomPopulator() {
		return false;
	}

	public boolean hasCustomCaves() {
		return false;
	}

	public abstract void generateCaves(Object parent, int x, int z, byte[] abyte);

}
