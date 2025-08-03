package com.scratchernoobyt.noobicore;

import org.bukkit.plugin.java.JavaPlugin;
import com.scratchernoobyt.noobicore.gestores.GestorPrefijosYaml;
import com.scratchernoobyt.noobicore.escuchas.*;

public class NoobiCore extends JavaPlugin {
    @Override
    public void onEnable() {
        GestorPrefijosYaml.cargar(this);
        getServer().getPluginManager().registerEvents(new EscuchaChat(), this);
        getServer().getPluginManager().registerEvents(new EscuchaConexion(), this);
        getLogger().info("✅NoobiCore ACTIVADO.");
    }
    public void onDisable() {
        GestorPrefijosYaml.guardar();
        getLogger().info("❌NoobiCore DESACTIVADO");
    }
}
