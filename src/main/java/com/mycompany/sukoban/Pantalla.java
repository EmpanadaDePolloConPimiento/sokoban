package com.mycompany.sukoban;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pantalla extends JPanel {
    private int tileSize = 32;
    private BufferedImage imagen;
    private final String CAJA = "sprites/caja.png";
    private final String PARED = "sprites/pared.png";
    private final String PERSONAJE = "sprites/personaje.png";
    private final String SUELO = "sprites/suelo.png";
    private final String BOTON = "sprites/boton.png";
    
    LevelManager manager = new LevelManager();
     protected static int numeroNivel = 120;
     private char[][] mapa;
     private String titulo;
    public Pantalla(){
        try{       
              mapa = LevelManager.getNiveles().get(numeroNivel).getMapa();
              titulo =  LevelManager.getNiveles().get(numeroNivel).getTitulo();
              

              tileSize = bestTileSize();
              imagen = ImageIO.read(new File(CAJA));
              JLabel label = new JLabel();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen == null){return;}
        g.setFont(new Font("Arial", Font.BOLD, 20)); 
        g.drawString(titulo, 20, 60);
        
        int desplazamientoX = 300;        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                try{
                    switch (mapa[i][j]) {
                        case '#' -> g.drawImage(ImageIO.read(new File(PARED)), desplazamientoX +j*tileSize,  i*tileSize, tileSize, tileSize, this);
                        case '@' -> g.drawImage(ImageIO.read(new File(PERSONAJE)), desplazamientoX + j*tileSize,  i*tileSize, tileSize, tileSize, this);
                        case '$' -> g.drawImage(ImageIO.read(new File(CAJA)), desplazamientoX +j*tileSize,  i*tileSize, tileSize, tileSize, this);
                        case ' ' -> g.drawImage(ImageIO.read(new File(SUELO)), desplazamientoX + j*tileSize, i*tileSize, tileSize, tileSize, this);
                        case '.' -> {}
                        default -> {
                        }
                    }
                
                }catch(Exception e){}
            }
        }
        
        
    }
    
    
    
    
    
    private int bestTileSize(){
        int casilla;
        int altura = mapa.length;
        int anchura = 0;
        for (int i = 0; i < altura; i++) {
            if(mapa[i].length > anchura){anchura = mapa[i].length;}
        }
        casilla = (altura>anchura) ? (Sokoban.HEIGHT / altura ): (Sokoban.WIDTH - 300) / anchura;
        casilla *= 0.95;
        System.out.println(mapa.length);

        return casilla;
    }
    

}
