/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniminuto.POO.lupinIII.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author NicoXtreme
 */
public class Contador {
    
    int minutos = 0;
    int segundos = 0;
    
    public Timer timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos++;
            if(segundos == 60){
                minutos++;
                segundos = 0;
            }
            System.out.println("Tiempo: " + minutos+":"+segundos);
        }
    });
}
