/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sukoban;

/**
 *
 * @author DAM1_Alu17
 */
public class Nivel {

    /**
     * @return the titulo
     */
    protected String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    protected void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;
    private char[][] mapa;
    
    public Nivel(String titulo, char[][] mapa){
        this.mapa = mapa;
        this.titulo = titulo;
    }

    /**
     * @return the mapa
     */
    protected char[][] getMapa() {
        return mapa;
    }

}
