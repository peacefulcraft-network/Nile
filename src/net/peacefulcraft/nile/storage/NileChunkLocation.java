package net.peacefulcraft.nile.storage;

import org.bukkit.Location;

public class NileChunkLocation {

	private final int XOFFSET = 0;
	private final int YOFFSET = 3;
	private final int ZOFFSET = 0;

	private final int XLENGTH = 20;
	private final int YLENGTH = 16;
	private final int ZLENGTH = 21;
	
	private String world;
		public String getWorld() { return this.world; }

	private int x;
		/**
		 * @return Nile Chunk Location X
		 */
		public int getX() { return this.x; }

	private int y;
		/**
		 * @return Nile Chunk Location Y
		 */
		public int getY() { return this.y; }

	private int z;
		/**
		 * @return Nile Chunk Location Z
		 */
		public int getZ() { return this.z; }

	/**
	 * Creates a NileChunkLocation Object
	 * @param x Raw location X
	 * @param y Raw location Y
	 * @param z Raw location Z
	 */
	public NileChunkLocation(String world, int x, int y, int z) {
		this.world = world;
		this.x = (x/XLENGTH) + ((x/XLENGTH) * XOFFSET);
		this.y = (y/YLENGTH) + ((y/YLENGTH) * YOFFSET);
		this.z = (z/ZLENGTH) + ((z/ZLENGTH) * ZOFFSET);
	}

	/**
	 * Creates a NileChunkObject from location
	 */
	public NileChunkLocation(Location loc) {
		this(
			loc.getWorld().getName(), 
			loc.getBlockX(), 
			loc.getBlockY(), 
			loc.getBlockZ()
		);
	}
}
