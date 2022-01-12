package net.peacefulcraft.nile.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.peacefulcraft.nile.Nile;

public class ExampleCommand implements CommandExecutor {

  /**
   * @param sender Entity which used the command.
   * @param Command Object with details about the executed command
   * @param String label String with the command run, without the passed arguements.
   * @param String args The arguements passed by the player. Each space in the command counts as a new argument. 
   */
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    sender.sendMessage(Nile.messagingPrefix + "You used the example command!");
    return true;
  }
  
}