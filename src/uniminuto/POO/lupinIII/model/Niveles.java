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
    private static Niveles niveles;
    
    /*Recibe el entero con el número del nivel
    Retorno*/
    private Niveles(int nivel) {
        this.nivel = nivel;
        System.out.println("Se ha instanciado la clase Niveles por primera y unica vez");
    }

    public static Niveles getSingletonInstance(int nivel) {
        if (niveles == null){
            niveles = new Niveles(nivel);
        }
        else{
            System.out.println("Nuevo nivel, no se instancia la clase Niveles de nuevo");
        }
        
        return niveles;
    }
    

    
    int nivel;
    SeleccionNivel n = new SeleccionNivel();

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
                        
                        n.Nivel1.setVisible(true);
        } 
        if (nivel==2) {
                        n.Nivel1.setVisible(true);
                        n.Nivel2.setVisible(true);
        }
        if(nivel==3){
                        n.Nivel1.setVisible(true);
                        n.Nivel2.setVisible(true);
                        n.Nivel3.setVisible(true);
        }
        if(nivel==4){
                        n.Nivel1.setVisible(true);
                        n.Nivel2.setVisible(true);
                        n.Nivel3.setVisible(true);
                        n.Nivel4.setVisible(true);
        }
         if(nivel==5){
                        n.Nivel1.setVisible(true);
                        n.Nivel2.setVisible(true);
                        n.Nivel3.setVisible(true);
                        n.Nivel4.setVisible(true);
                        n.Nivel5.setVisible(true);
        }
        n.setNiveles(nivel);
        n.setVisible(true);
   }

}
