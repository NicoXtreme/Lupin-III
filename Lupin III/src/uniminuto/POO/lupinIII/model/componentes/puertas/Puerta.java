package uniminuto.POO.lupinIII.model.componentes.puertas;

import uniminuto.POO.lupinIII.model.componentes.Bloqueador;
import uniminuto.POO.lupinIII.model.componentes.Desbloqueable;
import uniminuto.POO.lupinIII.model.componentes.Dinamico;
import uniminuto.POO.lupinIII.model.componentes.Push;

public class Puerta extends Push implements Bloqueador, Desbloqueable {

	protected boolean block;
	
	public Puerta(int i, int j) {
		super(i, j, '[');
		block=true;
	}

	@Override
	public boolean presionar(Dinamico d) {
		if(this.estaPresionado()) return false;
		if(!(d instanceof AbridorPuerta)) return false;
		block = !super.presionar(d);
		return !block;
	}

	public boolean estaBloqueada() {
		return block;
	}

	public boolean sePuedeDesbloquear(Dinamico d) {
		if(block==false) return true;
		if(!(d instanceof AbridorPuerta)) return false;
		return true;
	}

}
