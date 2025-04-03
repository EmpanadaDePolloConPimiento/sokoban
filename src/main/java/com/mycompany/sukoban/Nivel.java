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
    private int altura;
    private String mapa;
    
    public Nivel(String titulo, String mapa, int altura){
        this.mapa = mapa;
        this.titulo = titulo;
        this.altura = altura;
    }

    /**
     * @return the mapa
     */
    protected String getMapa() {
        return mapa;
    }

    /**
     * @param mapa the mapa to set
     */
    protected void setMapa(String mapa) {
        this.mapa = mapa;
    }

    /**
     * @return the altura
     */
    protected int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    protected void setAltura(int altura) {
        this.altura = altura;
    }
    
}
