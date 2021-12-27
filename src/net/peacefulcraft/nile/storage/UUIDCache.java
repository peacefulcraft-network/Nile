package net.peacefulcraft.nile.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UUIDCache {
	
	private Map<UUID, String> uuidMap;
	private Map<String, UUID> usernameMap;

	public UUIDCache() {
		this.uuidMap = Collections.synchronizedMap(new HashMap<UUID, String>());
		this.usernameMap = Collections.synchronizedMap(new HashMap<String, UUID>());
	}

	// TODO: caching
}
