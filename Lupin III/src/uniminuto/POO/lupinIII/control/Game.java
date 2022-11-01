package uniminuto.POO.lupinIII.control;

import uniminuto.POO.lupinIII.gui.TableroGUI;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.exceptions.ArchivoCorruptoException;

public class Game extends JFrame{

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
		try {
                    new Game(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIII.txt")
                            .getPath().replaceAll("%20", " "));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchivoCorruptoException e) {
			e.printStackTrace();
		}
	}

}
