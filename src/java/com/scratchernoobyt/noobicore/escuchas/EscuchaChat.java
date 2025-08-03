package com.scratchernoobyt.noobicore.escuchas;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import com.scratchernoobyt.noobicore.gestores.GestorPrefijosYaml;

public class EscuchaChat implements Listener {
    
    @EventHandler
    public void alChatear(AsyncPlayerChatEvent evento) {
        Player jugador = evento.getPlayer();
        String prefijo = GestorPrefijosYaml.obtenerPrefijo(jugador);
        String mensaje = evento.getMessage();

        evento.setFormat(ChatColor.translateAlternateColorCodes('&', prefijo + ChatColor.RESET + " " + jugador.getName() + ": " + mensaje));
    }
}
