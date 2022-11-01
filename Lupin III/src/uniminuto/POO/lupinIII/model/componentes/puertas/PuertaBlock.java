package uniminuto.POO.lupinIII.model.componentes.puertas;

import uniminuto.POO.lupinIII.model.componentes.Dinamico;

public class PuertaBlock extends Puerta{

	public PuertaBlock(int i, int j) {
		super(i, j);
		this.c = '{';
		block = true;
	}

	@Override
	public boolean presionar(Dinamico d) {
		if(this.estaPresionado()) return false;
		if(!(d instanceof AbridorPuertaBlock)) return false;
		if(((AbridorPuertaBlock)d).usarLlave()){
			block = !super.presionar(d);
			return !block;
		}else
			return false;
	}

	public boolean estaBloqueada() {
		return block;
	}

	public boolean sePuedeDesbloquear(Dinamico d) {
		if(block==false) return true;
		if(!(d instanceof AbridorPuertaBlock)) return false;
		return ((AbridorPuertaBlock)d).tengoLlave();
	}

}
