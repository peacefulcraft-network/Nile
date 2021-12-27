package net.peacefulcraft.nile.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NileClaimStore {
	
	protected Map<String, NileClaim> claimCache;
	protected Map<String, NileChunk> chunkCache;
	protected Map<UUID, List<String>> claimMembershipCache;
	protected Map<UUID, List<NileChunkPermissionLevel>> claimPermissionsCache;

	public NileClaimStore() {

		this.claimCache = Collections.synchronizedMap(new HashMap<String, NileClaim>());
		this.chunkCache = Collections.synchronizedMap(new HashMap<String, NileChunk>());
		this.claimMembershipCache = Collections.synchronizedMap(new HashMap<UUID, List<String>>());
		this.claimPermissionsCache = Collections.synchronizedMap(new HashMap<UUID, List<NileChunkPermissionLevel>>());
	}

	protected static String getClaimKey(String owner, String claimName) {
		return owner + ":" + claimName;
	}

	protected static String getChunkKey(NileChunk chunk) {
		return getChunkKey(chunk.getWorld(), chunk.getChunkX(), chunk.getChunkY(), chunk.getChunkZ());
	}

	protected static String getChunkKey(String world, int x, int y, int z) {
		return world + "_" + x + "_" + y + "_" + z;
	}

	public void evictCachedChunk(NileChunk chunk) {
		this.chunkCache.remove(getChunkKey(chunk));
	}

	public void evictCachedChunk(String world, int x, int y, int z) {
		this.chunkCache.remove(getChunkKey(world, x, y, z));
	}

	/**
	 * Creates a new named claim object. Performs blocking SQL work.
	 * Inserts NileChunk object into cache
	 * @param chunk
	 */
	public void insertChunkCache(NileChunk chunk) {
		if (chunk == null) { return; }

		this.chunkCache.put(
			getChunkKey(chunk), 
			chunk
		);
	}

	public NileClaim createClaim(String claimName, UUID owner) {
		/*
		String username = Nile.getUUIDCache().uuidToUsername(owner);
		NileClaim claim = getClaim(getClaimKey(username, claimName));

		if (claim == null) {
			claim = SQLQueries.createClaim(claimName, owner);

			// TODO: Undo this comment block
			this.claimMembershipCache.get(owner).add(getClaimKey(username, claimName));

		}
		*/
		return null;
	}
}
