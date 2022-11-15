package uniminuto.POO.lupinIII.model.memento;

import uniminuto.POO.lupinIII.gui.TableroGUI;

public class Originator {

	private TableroGUI estado;

	public void setEstado(TableroGUI estado) {
		this.estado = estado;
	}

	public TableroGUI getEstado() {
		return estado;
	}

	public Memento guardar() {
		return new Memento(estado);
	}

	public TableroGUI restaurar(Memento m) {
		return m.getEstado();
	}
}
