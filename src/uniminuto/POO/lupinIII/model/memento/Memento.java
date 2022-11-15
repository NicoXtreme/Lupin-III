package uniminuto.POO.lupinIII.model.memento;

import uniminuto.POO.lupinIII.gui.TableroGUI;

public class Memento {

	private TableroGUI estado;

	public Memento( TableroGUI estado) {
		this.estado = estado;
	}

	public TableroGUI getEstado() {
		return estado;
	}

}
