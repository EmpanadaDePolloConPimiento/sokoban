/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sukoban;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DAM1_Alu17
 */
public class LevelManager {
    //cargar nivel
    private static ArrayList<Nivel> niveles = new ArrayList<>();
    private String rutaArchivo = "niveles/prueba.txt"; // Ruta del archivo
    public void cargarNiveles(){
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean tituloLeido = false;
            String titulo = "";
            String mapa = "";
            while ((linea = br.readLine()) != null) { // Lee línea por línea
                if(linea.equals("")){
                    //Añade el nivel
                    getNiveles().add(new Nivel(titulo, mapa, getAlturaNivel(mapa)));
                    //Reset de valores para nuevo nivel
                    titulo = "";
                    mapa = "";
                    tituloLeido = false;
                    continue;
                }
                if(linea.contains("#")){tituloLeido = true;}
                if(!tituloLeido)
                {
                    if(titulo.equals(""))
                    {titulo = linea;}
                    else{
                        titulo = titulo +" - " + linea;
                    }
                }
                else{
                   
                    mapa = mapa + linea + "\n";
                }
              
                
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo : " + e.getMessage());
        }
    }

    public char[][] convertidorDeMapa(String mapa){    
        //Se recoge la altura del mapa de forma personalizada
        int alturaNivel = getAlturaNivel(mapa);
        //Se transforma el mapa a un array de char para poder trabajar con el más fácil 
        char mapaArray[] = mapa.toCharArray();
        //Se recoge la altura del mapa de forma personalizada
        int posicionDelMapa = 0;
        char[][] mapaTransformado = new char[alturaNivel][];
        for (int i = 0; i < alturaNivel; i++) {
            int longitudNivel = 0;
            
            int inicioDeLineaNivel = posicionDelMapa;
            
            char bandera = mapaArray[posicionDelMapa];
            while(bandera != '\n')
            {  
                longitudNivel++;
                posicionDelMapa++;
                bandera = mapaArray[posicionDelMapa];
            }
            
            //Creamos cada línea del nivel de forma personalizada
            mapaTransformado[i] = new char[longitudNivel];
            for (int j = 0; j < longitudNivel; j++) {
                mapaTransformado[i][j] = mapaArray[inicioDeLineaNivel + j];
                System.out.print(mapaTransformado[i][j]);
            }
            System.out.println("");
            //Esta posición añadida es necesaria para que el siguiente caracter no sea '\n' y pueda iterar en el while
            posicionDelMapa++;
        }
        return mapaTransformado;
    }
    
    private int getAlturaNivel(String mapa){
        int alturaNivel = 0;
        for (int i = 0; i < mapa.length(); i++) {
            if(mapa.charAt(i) == '\n'){alturaNivel++;}            
        }
        return alturaNivel;
    }

    /**
     * @return the niveles
     */
    static protected ArrayList<Nivel> getNiveles() {
        return niveles;
    }
}
