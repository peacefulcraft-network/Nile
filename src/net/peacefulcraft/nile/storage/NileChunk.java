package net.peacefulcraft.nile.storage;

import java.util.UUID;

public class NileChunk {
	
	private NileClaim claimMeta;
		public NileClaim getClaimMeta() { return this.claimMeta; }
		public void setClaimMeta(NileClaim claim) { this.claimMeta = claim; }
	
	private String world;
		public String getWorld() { return this.world; }
	private int x;
		/**
		 * @return Nile Chunk X cord based on offsets
		 */
		public int getChunkX() { return this.x; }
	private int y;
		/**
		 * @return Nile Chunk Y cord based on offsets
		 */
		public int getChunkY() { return this.y; }
	private int z;
		/**
		 * @return Nile Chunk Z cord based on offsets
		 */
		public int getChunkZ() { return this.z; }

	/**
	 * Nile Chunk constructor
	 * NOTE: cords passed through must be based on Nile Chunk Grid
	 * @param claimMeta Chunks claim meta
	 * @param world world chunk is located in
	 * @param x Nile Chunk Grid X
	 * @param y Nile Chunk Grid Y
	 * @param z Nile Chunk Grid Z
	 */
	public NileChunk(NileClaim claimMeta, String world, int x, int y, int z) {
		this.claimMeta = claimMeta;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean isChunkClaimed() {
		return this.claimMeta != null;
	}

	public boolean canUserBuild(UUID user) {
		return (
			this.claimMeta.getOwners().contains(user)
			|| this.claimMeta.getModerators().contains(user)
		);
	}
}
