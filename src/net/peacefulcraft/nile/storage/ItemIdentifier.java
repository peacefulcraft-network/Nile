package net.peacefulcraft.nile.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.gson.JsonObject;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.chat.hover.content.Item;

public class ItemIdentifier {
	
	/**
	 * Display name of item
	 */
	private String displayName;
		public String getDisplayName() { return this.displayName; }

	/**
	 * Applicable lore of item, if any
	 */
	private ArrayList<String> lore;
		public ArrayList<String> getLore() { return this.lore; }

	/**
	 * Material of item
	 */
	private Material material;
		public Material getMaterial() { return this.material; }
		
	/**
	 * Quantity of item
	 */
	private Integer quantity;
		public Integer getQuantity() { return this.quantity; }
		public void setQuantity(Integer i) { this.quantity = i; }

	/**
	 * Loading an item identifier from json object
	 */
	public ItemIdentifier(JsonObject obj) {
		displayName = obj.get("displayName").getAsString();
		lore = new ArrayList<String>(Arrays.asList(obj.get("lore").getAsString().split("\n")));
		material = Material.valueOf(obj.get("material").getAsString());
		quantity = obj.get("quantity").getAsInt();
	}

	public ItemIdentifier(ItemStack item) {
		ItemMeta meta = item.getItemMeta();

		displayName = meta.getDisplayName();
		lore = new ArrayList<String>(meta.getLore());
		material = item.getType();
		quantity = item.getAmount();
	}

	/**
	 * Takes an arraylist of items and converts into formatted item identifiers
	 * @param items list of items
	 * @return formatted item identifiers
	 */
	public static HashMap<Integer, ItemIdentifier> getAsItemIdentifiers(HashMap<Integer, ItemStack> items) {
		HashMap<Integer, ItemIdentifier> out = new HashMap<>();

		items.forEach((slot, item) -> {
			out.put(slot, new ItemIdentifier(item));
		});

		return out;
	}
}
