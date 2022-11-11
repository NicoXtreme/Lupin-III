/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniminuto.POO.lupinIII.model;

import lupinIII.menu.SeleccionNivel;


/**
 *
 * @author Ojitos
 */
public class Niveles {
    /* la variable que va a controlar las vidas
    */
int nivel;
   
   public Niveles(){
       nivel = 1;
    }
   
   public int getNiveles(){
    return nivel; 
   }
   
   public void setNiveles(int nivel){
      this.nivel = nivel; 
   }
    public void Desbloquear(int nivel){
        if (nivel == 1) {
            SeleccionNivel newframe = new SeleccionNivel();
                        
                        newframe.Nivel1.setVisible(true);
                        
             
        } 
        if (nivel==2) {
              SeleccionNivel newframe = new SeleccionNivel();
                        
                        newframe.Nivel2.setVisible(true);
                        
                        
                 
        }
        if(nivel==3){
              SeleccionNivel newframe = new SeleccionNivel();
                        
                        newframe.Nivel3.setVisible(true);
            
        }
        if(nivel==4){
              SeleccionNivel newframe = new SeleccionNivel();
                        
                        newframe.Nivel3.setVisible(true);
                        
                      
        }
          SeleccionNivel newframe = new SeleccionNivel();
         newframe.setVisible(true);
 
   }
   
   
}
