package uniminuto.POO.lupinIII.model.componentes.enemigos;

import uniminuto.POO.lupinIII.model.Direccion;
import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.componentes.Automatico;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Manual;

public class Perro extends Automatico implements Enemigo {

	public Perro(int i, int j) {
		super(i, j, 'D');
	}

	@Override
	public boolean mover(Tablero t) {
		return mover(t.getLadron(), t);
	}

	public Direccion buscar(Manual ladron, Tablero t) {
		return Direccion.azar();
	}

	public boolean mover(Manual ladron, Tablero t) {
		Direccion d = buscar(ladron, t);
		return mover(d, t);
	}

}
