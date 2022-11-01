package uniminuto.POO.lupinIII.model.componentes.estaticos;

import uniminuto.POO.lupinIII.model.componentes.Bloqueador;


public class Muro extends Estatico implements Bloqueador{

	public Muro(int i, int j) {
		super(i, j, '#');
	}

	public boolean estaBloqueada() {
		return true;
	}

}
