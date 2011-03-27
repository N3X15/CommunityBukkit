/**
 * 
 */
package org.bukkit;

/**
 * @author Rob
 *
 */
public interface WorldProvider {

	void setWorldChunkManager(WorldChunkManager wcm);
	void setChunkProvider(ChunkProvider cp);
}
