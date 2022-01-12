package net.peacefulcraft.nile.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.peacefulcraft.nile.Nile;

public class PlayerJoinListener implements Listener {
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent ev) {
    ev.getPlayer().sendMessage(Nile.messagingPrefix + "Welcome to the server! -Templateus");
  }
}