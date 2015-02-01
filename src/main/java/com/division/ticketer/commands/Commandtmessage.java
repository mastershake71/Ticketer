/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.division.ticketer.commands;

import com.division.ticketer.config.TicketerConfig;
import com.division.ticketer.core.Rank;
import com.division.ticketer.core.ActiveTicket;
import com.division.ticketer.core.Ticketer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author Evan
 */
public class Commandtmessage extends TicketerCommand {

    public String stringBuilder(String[] bits) {
        StringBuilder output = new StringBuilder();
        for (String s : bits) {
            output.append(s);
            output.append(" ");
        }
        return output.toString();
    }

    @Override
    public void run(Ticketer TI, Player sender, String commandLabel, Command command, String[] args) {
        String rankformat = TicketerConfig.getRankFormat(Rank.SYSTEM);
        ChatColor chatformat = TicketerConfig.getChatColor();
        ActiveTicket tick = TI.getTicket(sender);
        if (args.length > 0) {
            if (tick != null) {
                tick.setMessage(stringBuilder(args));
                sender.sendMessage(rankformat + ": " + chatformat + "Your message has been set to: " + stringBuilder(args));
            } else {
                sender.sendMessage(rankformat + ": " + chatformat + "You do not have a pending ticket. Use /tcreate to start a ticket.");
            }
        } else {
            sender.sendMessage(rankformat + ": " + chatformat + "You need to specify a message.");
        }
    }
}
