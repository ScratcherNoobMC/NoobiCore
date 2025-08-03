package com.scratchernoobyt.noobicore.gestores;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.Map;

public class GestorPermisos {
    private final JavaPlugin plugin;
    private final Map<Player, PermissionAttachment> permisosActivos = new HashMap<>();
    
    public GestorPermisos(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void asignar(Player jugador, String permiso) {
        PermissionAttachment attach = permisosActivos.computeIfAbsent(jugador, p -> p.addAttachment(plugin));
        attach.setPermission(permiso, true);
    }

    public void quitar(Player jugador, String permiso) {
        PermissionAttachment attach = permisosActivos.get(jugador);
        if (attach != null) {
            attach.unsetPermission(permiso);
        }
    }

    public Map<String, Boolean> listar(Player jugador) {
        PermissionAttachment attach = permisosActivos.get(jugador);
        return attach != null ? attach.getPermissions() : Map.of();
    }
}