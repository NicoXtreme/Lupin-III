package uniminuto.POO.lupinIII.control;

import uniminuto.POO.lupinIII.gui.TableroGUI;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lupinIII.menu.SeleccionNivel;

import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.exceptions.ArchivoCorruptoException;

public class Game extends javax.swing.JFrame{
	private static final long serialVersionUID = 6708958011929656475L;

	public Game(String path,int nivel, int vidas) throws FileNotFoundException, ArchivoCorruptoException{
		Tablero t = new Tablero(path);
		TableroGUI tgui = new TableroGUI(t);
                tgui.setPiso(nivel);
		this.add(tgui);
		tgui.setFocusable(true);
		this.setSize(t.getWidth()*30, t.getHeight()*30);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public  Game(int nivel, Tablero t, TableroGUI tgui){
                tgui.actualizar();
                
		this.add(tgui);
		tgui.setFocusable(true);
		this.setSize(t.getWidth()*30, t.getHeight()*30);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        
        
	public static void main(String[] args) {
	}
        
   
}
