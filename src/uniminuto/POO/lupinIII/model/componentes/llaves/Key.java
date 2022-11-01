package uniminuto.POO.lupinIII.model.componentes.llaves;

import uniminuto.POO.lupinIII.model.componentes.Dinamico;
import uniminuto.POO.lupinIII.model.componentes.Push;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Manual;


public class Key extends Push {

	public Key(int i, int j) {
		super(i, j, 'K');
	}

	@Override
	public boolean presionar(Dinamico d) {
		if(this.estaPresionado()) return false;
		if(!(d instanceof Manual)) return false;
		return super.presionar(d);
	}

}
