package com.scratchernoobyt.noobicore.data;

import java.util.*;

public class PrefijoData {
    private final String prefijo;
    private final Set<String> permisos;

    public PrefijoData(String prefijo) {
        this.prefijo = prefijo;
        this.permisos = new HashSet<>();
    }

    public String getPrefijo() {
        return prefijo;
    }

    public Set<String> getPermisos() {
        return permisos;
    }

    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso.toLowerCase());
    }

    public void añadirPermiso(String permiso) {
        permisos.add(permiso.toLowerCase());
    }
}
