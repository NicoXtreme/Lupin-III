package uniminuto.POO.lupinIII.gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.componentes.enemigos.Perro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Muro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Piso;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Ladron;
import uniminuto.POO.lupinIII.model.componentes.puertas.Puerta;
import uniminuto.POO.lupinIII.model.componentes.puertas.PuertaBlock;
import uniminuto.POO.lupinIII.model.componentes.tesoros.Tesoro;
import uniminuto.POO.lupinIII.model.componentes.llaves.Key;
import uniminuto.POO.lupinIII.model.Direccion;

public class TableroGUI extends JPanel {

    private static final long serialVersionUID = -9055090534930735030L;
    private static HashMap<Class, Image> imgs;
    private static Class[] clases = {Perro.class, Muro.class, Piso.class,
        Ladron.class, Key.class, Puerta.class, PuertaBlock.class,
        Tesoro.class};
    private PanelFondo[][] m;
    private Tablero t;

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
            if (!t.terminoJuego()) {
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
            if (d != Direccion.STOP) {
                t.moverLadron(d);
                tgui.actualizar();
                if (t.terminoJuego()) {
                    if (t.gano()) {
                        JOptionPane.showMessageDialog(null, "Felicidades");
                    } else {
                        JOptionPane.showMessageDialog(null, "Perdio");
                    }
                }
            }
            super.keyPressed(e);
        }
    }
}
