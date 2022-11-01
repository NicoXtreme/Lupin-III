package uniminuto.POO.lupinIII.model.componentes.tesoros;

import uniminuto.POO.lupinIII.model.componentes.Dinamico;
import uniminuto.POO.lupinIII.model.componentes.Push;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Manual;


public class Tesoro extends Push {

	public Tesoro(int i, int j) {
		super(i, j, '$');
	}

	@Override
	public boolean presionar(Dinamico d) {
		if(this.estaPresionado()) return false;
		if(!(d instanceof Manual)) return false;
		return super.presionar(d);
	}
	
}
