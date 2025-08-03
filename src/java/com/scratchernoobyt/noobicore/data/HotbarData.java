package com.scratchernoobyt.noobicore.data;

public class HotbarData {
    private String texto;
    private int duracion;

    public HotbarData(String texto, int duracion) {
        this.texto = texto;
        this.duracion = duracion;
    }

    public String getTexto() { return texto; }
    public int getDuracion() { return duracion;}
    public void setTexto(String nuevoTexto) {this.texto = nuevoTexto; }
}
