package uniminuto.POO.lupinIII.gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lupinIII.menu.SeleccionNivel;

import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.Vidas;
import uniminuto.POO.lupinIII.model.componentes.enemigos.Perro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Muro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Piso;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Ladron;
import uniminuto.POO.lupinIII.model.componentes.puertas.Puerta;
import uniminuto.POO.lupinIII.model.componentes.puertas.PuertaBlock;
import uniminuto.POO.lupinIII.model.componentes.tesoros.Tesoro;
import uniminuto.POO.lupinIII.model.componentes.llaves.Key;
import uniminuto.POO.lupinIII.model.Direccion;
import uniminuto.POO.lupinIII.model.Niveles;
import uniminuto.POO.lupinIII.model.memento.Caretaker;
import uniminuto.POO.lupinIII.model.memento.Originator;
import uniminuto.POO.lupinIII.control.Game;

public class TableroGUI extends JPanel {

    private static final long serialVersionUID = -9055090534930735030L;
    private static HashMap<Class, Image> imgs;
    private static Class[] clases = {Perro.class, Muro.class, Piso.class,
        Ladron.class, Key.class, Puerta.class, PuertaBlock.class,
        Tesoro.class};
    private PanelFondo[][] m;
    private Tablero t;
    private Vidas vidas;
    
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    
    SeleccionNivel n_lost = new SeleccionNivel();
    
    private Niveles niveles = Niveles.getSingletonInstance(WIDTH);
    int piso=1;
    int vidasRest=1;
          
      
    public TableroGUI(Tablero t) {
        this.t = t;
        imgs = new HashMap<Class, Image>();
        for (Class c : clases) {
            String name = c.getName().substring(
                    c.getName().lastIndexOf(".") + 1)
                    + ".gif";
            Image img = new ImageIcon(this.getClass().
                    getResource("/uniminuto/POO/lupinIII/imagenes/" + name).getPath().replaceAll("%20", " ")).getImage();
            imgs.put(c, img);
        }

        m = new PanelFondo[t.getHeight()][t.getWidth()];
        actualizar();
        vidas = new Vidas();
        niveles = new Niveles();

        this.addKeyListener(new EvTeclado(t, this));    
       
        
    }

    public void actualizar() {
        this.removeAll();
        this.setLayout(new GridLayout(m.length, m[0].length, 0, 0));
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                m[i][j] = new PanelFondo(imgs.get(t.getClass(i, j)));
                this.add(m[i][j]);
            }
        }
        this.updateUI(); 
        
    }

    private class EvTeclado extends KeyAdapter {

        private Tablero t;
        private TableroGUI tgui;

        public EvTeclado(Tablero t, TableroGUI tgui) {
            this.t = t;
            this.tgui = tgui;
            
        }

        @Override
        public void keyPressed(KeyEvent e) {

            Direccion d = Direccion.STOP;
            if (!t.terminoJuego()|| vidasRest>0) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    d = Direccion.ARRIBA;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    d = Direccion.ABAJO;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    d = Direccion.DERECHA;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    d = Direccion.IZQUIERDA;
                }
            }
            //COMPROBADOR, PARA SABER SI UN NIVEL SE SUPERO Y DESBLOQUEAR EL SIGUIENTE
            if (d != Direccion.STOP|| vidasRest>0) {
                
                originator.setEstado(tgui);
                caretaker.addMemento(originator.guardar());

                t.moverLadron(d);
                tgui.actualizar();             
                
                if (t.terminoJuego()) {
                    System.out.println(t.gano());                    
                    
                    if (t.gano()) {                  
                       
                        if(piso+1==6){
                            n_lost.lostGame();
                        }else{
                            niveles.setNiveles(piso+1);
                            piso = niveles.getNiveles();                             
                            niveles.Desbloquear(piso);                       
                            //setNivelDesbloqueado(piso);
                            setPiso(piso);
                        }
                   
                        
                    } else {
                        vidas.setVidas(vidas.getVidas()-1);
                         vidasRest = vidas.getVidas();
                         
                        if (vidasRest == 0){
                            JOptionPane.showMessageDialog(null, "Perdió");
                            n_lost.lostGame();
                            
                        }else{   
                            System.out.println(tgui.piso);
                            n_lost.lostLife(
                                        JOptionPane.showConfirmDialog(null, "Le queda(n) "+vidasRest+" vida(s)."),
                                        t,
                                        originator.restaurar(caretaker.getMemento())
                            );                              
                            
                        } 
                        
                    }
                }
            }
            super.keyPressed(e);
        }
     
        
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    public void setNivelDesbloqueado(int piso){
        this.niveles.Desbloquear(piso); 
    }
}
