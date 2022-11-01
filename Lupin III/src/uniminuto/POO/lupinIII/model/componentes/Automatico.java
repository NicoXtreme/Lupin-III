package uniminuto.POO.lupinIII.model.componentes;

import uniminuto.POO.lupinIII.model.Tablero;

public abstract class Automatico extends Dinamico {

	public Automatico(int i, int j) {
		super(i, j);
	}
	
	public Automatico(int i, int j, int vel) {
		super(i, j, vel);
	}
	
	public Automatico(int i, int j, char c) {
		super(i, j, c);
	}
	
	public Automatico(int i, int j, char c, int vel) {
		super(i, j, c, vel);
	}
	
	public abstract boolean mover(Tablero t);

}
