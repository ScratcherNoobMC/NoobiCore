package com.scratchernoobyt.noobicore.escuchas;

import com.scratchernoobyt.noobicore.gestores.GestorPrefijosYaml;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class EscuchaConexion implements Listener {

    @EventHandler
    public void alEntrar(PlayerJoinEvent evento) {
        Player jugador = evento.getPlayer();
        if (GestorPrefijosYaml.tienePrefijo(jugador)) {
            String prefijo = GestorPrefijosYaml.obtenerPrefijo(jugador);
            jugador.setPlayerListName(prefijo + ChatColor.RESET + jugador.getName());
        }
        else {
            jugador.setPlayerListName(jugador.getName());
        }
    }
    
}
