package com.scratchernoobyt.noobicore.gestores;

import com.scratchernoobyt.noobicore.data.PrefijoData;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GestorPrefijosYaml {
    public static final Map<UUID, PrefijoData> datos = new HashMap<>();
    public static YamlConfiguration config;
    public static File archivo;

    public static void cargar(JavaPlugin plugin) {
        archivo = new File(plugin.getDataFolder(), "prefijos.yml");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(archivo);
        datos.clear();

        for (String clave : config.getKeys(false)) {
            UUID uuid = UUID.fromString(clave);
            String prefijo = config.getString(clave + ".prefijo");
            List<String> permisos = config.getStringList(clave + ".permisos");

            PrefijoData data = new PrefijoData(prefijo);
            permisos.forEach(data::añadirPermiso);
            datos.put(uuid, data);
        }
    }

    public static void guardar() {
        for (Map.Entry<UUID, PrefijoData> entry : datos.entrySet()) {
            String uuid = entry.getKey().toString();
            PrefijoData data = entry.getValue();
            config.set(uuid + ".prefijo", data.getPrefijo());
            config.set(uuid + ".permisos", new ArrayList<>(data.getPermisos()));
        }
        try {
            config.save(archivo);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static void asignarPrefijo(Player jugador, String prefijo) {
        datos.put(jugador.getUniqueId(), new PrefijoData(prefijo));
        jugador.setPlayerListName(prefijo + " " + ChatColor.RESET + jugador.getName());
        guardar();
    }

    public static void eliminarPrefijo(Player jugador) {
        datos.remove(jugador.getUniqueId());
        jugador.setPlayerListName(jugador.getName());
        guardar();
    }

    public static void añadirPermisoPorPrefijo(String prefijo, String permiso) {
        for (UUID uuid : datos.keySet()) {
            PrefijoData data = datos.get(uuid);
            if (data.getPrefijo().equalsIgnoreCase(prefijo)) {
                data.añadirPermiso(permiso);
                Player jugador = Bukkit.getPlayer(uuid);
            }
        }
        guardar();
    }

    public static boolean tienePermiso(Player jugador, String permiso) {
        PrefijoData data = datos.get(jugador.getUniqueId());
        return data != null && data.tienePermiso(permiso);
    }

    public static String obtenerPrefijo(Player jugador) {
        PrefijoData data = datos.get(jugador.getUniqueId());
        return (data != null) ? data.getPrefijo() : "";
    }

    public static boolean tienePrefijo(Player jugador) {
        return datos.containsKey(jugador.getUniqueId());
    }
}