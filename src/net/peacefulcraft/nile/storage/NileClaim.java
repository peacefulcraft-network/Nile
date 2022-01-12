package net.peacefulcraft.nile.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NileClaim {
	
	private int claimId;
		public int getClaimId() { return this.claimId; }
	
	private String claimName;
		public String getClaimName() { return this.claimName; }

	private List<NileChunk> chunks;
		public List<NileChunk> getChunks() { return this.chunks; }

	private List<UUID> owners;
		public List<UUID> getOwners() { return Collections.unmodifiableList(this.owners); }
	private List<UUID> moderators;
		public List<UUID> getModerators() { return Collections.unmodifiableList(this.moderators); }

	/** Current stores money amount */
	private Integer wallet;
		public void deposit(int amount) { wallet += amount; }

	public NileClaim(int claimId, String claimName, List<UUID> owners, List<UUID> moderators, Integer wallet) {
		this.claimId = claimId;
		this.claimName = claimName;

		this.chunks = Collections.synchronizedList(new ArrayList<NileChunk>());
		this.owners = Collections.synchronizedList(owners);
		this.moderators = Collections.synchronizedList(moderators);

		this.wallet = wallet;
	}

	/**
	 * Add the user as a chunk owner
	 * @param owner UUID of the user to add
	 * 
	 * @throws IllegalArgumentException If user is already a chunk owner
	 */
	public void addOwner(UUID owner) {
		// TODO: SQL set owner modification
		this.owners.add(owner);

		// TODO: Trigger cache update by user
	}

	/**
	 * Remove the provided user as a chunk owner
	 * @param owner UUID of user to remove
	 * @throws IllegalArgumentException If user is not owner
	 */
	public void removeOwner(UUID owner) {
		// TODO: SQL remove owner modification
		this.owners.remove(owner);

		// TODO: Trigger cache update by user
	}

	/**
	 * Add the provided user as a chunk moderator
	 * @param moderator UUID of user to add
	 * @throws IllegalArgumentException If user is already moderator
	 */
	public void addModerator(UUID moderator) {
		// TODO: SQL set moderator modification
		this.moderators.add(moderator);

		// TODO: Trigger cache update by user
	}

	/**
	 * Remove the provided user as chunk moderator
	 * @param moderator UUID of user to remove
	 * @throws IllegalArgumentException If user is not moderator
	 */
	public void removeModerator(UUID moderator) {
		//TODO: SQL remove moderator modification
		this.moderators.remove(moderator);

		// TODO: Trigger cache update by user
	}
}
