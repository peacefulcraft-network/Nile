package net.peacefulcraft.nile.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

public class NileInventory {
	private List<UUID> owners;
		public List<UUID> getOwners() { return Collections.unmodifiableList(owners); }

	private HashMap<Integer, ItemIdentifier> items;
	
	/**Physical location of sign */
	private Location signLocation;
		public Location getLocation() { return signLocation; }

	private NileClaim parent;

	public NileInventory(Location loc, NileClaim parent) {
		this.signLocation = loc.clone();
		this.owners = Collections.synchronizedList(parent.getOwners());
		this.parent = parent;
	}

	/**
	 * Adds item to internal inventory
	 * @param slot Desired slot in inventory
	 * @param ident
	 */
	public void addItem(Integer slot, ItemIdentifier ident) {
		this.items.put(slot, ident);
	}

}
