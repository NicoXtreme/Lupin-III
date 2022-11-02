package uniminuto.POO.lupinIII.control;

import uniminuto.POO.lupinIII.gui.TableroGUI;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lupinIII.menu.SeleccionarNivel;

import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.exceptions.ArchivoCorruptoException;

public class Game extends javax.swing.JFrame{
	private static final long serialVersionUID = 6708958011929656475L;

	public Game(String path) throws FileNotFoundException, ArchivoCorruptoException{
		Tablero t = new Tablero(path);
		TableroGUI tgui = new TableroGUI(t);
		this.add(tgui);
		tgui.setFocusable(true);
		this.setSize(t.getWidth()*30, t.getHeight()*30);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
            SeleccionarNivel nivel = new SeleccionarNivel();
    
            int level = nivel.nivel;    
            
            if(level == 1){
                try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIIINivel1.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
            }
            if(level == 2){
                try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIIINivel2.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
            }
            if(level == 3){
                try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIIINivel3.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
            }
            if(level == 4){
                try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIIINivel4.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
            }
            if(level == 5){
                try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIIINivel5.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
            }
	}
   
}
