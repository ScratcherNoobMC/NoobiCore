package com.scratchernoobyt.noobicore.gestores;

import java.util.*;
import org.bukkit.entity.Player;
import com.scratchernoobyt.noobicore.data.HotbarData;
import com.scratchernoobyt.noobicore.util.PlaceholderReplacer;

public class GestorHotbar {
    private static final Map<String, HotbarData> hotbars = new HashMap<>();

    public static void crear(String nombre, String texto, int duracion, Player jugador) {
        hotbars.put(nombre.toLowerCase(), new HotbarData(PlaceholderReplacer.aplicar(jugador, texto), duracion));
    }

    public static HotbarData obtener(String nombre) {
        return hotbars.get(nombre.toLowerCase());
    }

    public static boolean existe(String nombre) {
        return hotbars.containsKey(nombre.toLowerCase());
    }

    public static void eliminar(String nombre) {
        hotbars.remove(nombre.toLowerCase());
    }
}
