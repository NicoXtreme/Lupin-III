package uniminuto.POO.lupinIII.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	private static final long serialVersionUID = -8364642964982782694L;
	
	private Image img;
	
	public PanelFondo(Image img) {
		super();
		this.img = img;
		this.setSize(img.getWidth(null),img.getHeight(null));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img,0,0,null);
	}

}
