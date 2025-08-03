package com.scratchernoobyt.noobicore.util;

import org.bukkit.entity.Player;

public class PlaceholderReplacer {

    public static String aplicar(Player jugador, String mensaje) {
        if (mensaje == null) return "";

        mensaje = mensaje.replace("%jugador%", jugador.getName());
        mensaje = mensaje.replace("%mundo%", jugador.getWorld().getName());

        try {
            int ping = jugador.getPing();
            mensaje = mensaje.replace("%ping%", String.valueOf(ping));
        }

        catch (Exception e) {
            mensaje = mensaje.replace("%ping%", "N/A");
        }

        return mensaje;
    }    
}
