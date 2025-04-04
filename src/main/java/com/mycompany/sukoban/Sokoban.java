/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sukoban;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Sokoban {
    protected static final int WIDTH = 900;
    protected static final int HEIGHT = 600;
    private JFrame frame;
    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new Sokoban().iniciar());  
    }
    
        
        private void iniciar(){
        frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        
        LevelManager l = new LevelManager();
        l.cargarNiveles();
        frame.add(new Pantalla());
        frame.setVisible(true);
        leerTeclado();
        
        
    }

        
        
        
        public void leerTeclado(){
        frame.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            private final int ABAJO = 40;
            private final int ARRIBA = 38;
            private final int IZQ = 37;
            private final int DER = 39;
            @Override
            public void keyPressed(KeyEvent e) {
                 if(e.getKeyCode() == ARRIBA){}
                 if(e.getKeyCode() == ABAJO){}
                 if(e.getKeyCode() == IZQ){}
                 if(e.getKeyCode() == DER){}
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
            }
        });
        
        }
}

