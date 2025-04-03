package com.mycompany.sukoban;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pantalla extends JPanel {
    private int tileSize = 32;
    private BufferedImage imagen;
    private final String CAJA = "sprites/caja.png";
    private final String PARED = "sprites/pared.png";
    private final String PERSONAJE = "sprites/personaje.png";
      
      LevelManager manager = new LevelManager();
      
     private char[][] mapa = manager.convertidorDeMapa(LevelManager.getNiveles().getFirst().getMapa());
     
     
    public Pantalla(){
        try{
            
              imagen = ImageIO.read(new File(CAJA));
             
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen == null){return;}
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length*2; j++) {
                try{
                if(mapa[i][j] == '#'){
                    g.drawImage(ImageIO.read(new File(PARED)), j*tileSize, i*tileSize, tileSize, tileSize, this);
                    
                } 
                else if(mapa[i][j] == '@'){
                    g.drawImage(ImageIO.read(new File(PERSONAJE)), j*tileSize, i*tileSize, tileSize, tileSize, this);
                }
                else if(mapa[i][j] == '$'){
                    g.drawImage(ImageIO.read(new File(CAJA)), j*tileSize, i*tileSize, tileSize, tileSize, this);
                }
                
                }catch(Exception e){}
            }
        }
        
        
    }
            
    
}
