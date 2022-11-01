package uniminuto.POO.lupinIII.model.componentes.ladrones;

import uniminuto.POO.lupinIII.model.componentes.Dinamico;
import uniminuto.POO.lupinIII.model.componentes.llaves.Key;
import uniminuto.POO.lupinIII.model.componentes.puertas.AbridorPuerta;
import uniminuto.POO.lupinIII.model.componentes.puertas.AbridorPuertaBlock;

public abstract class Manual extends Dinamico implements AbridorPuerta,
		AbridorPuertaBlock {

	private Key key;

	public Manual(int i, int j) {
		super(i, j);
	}

	public Manual(int i, int j, int vel) {
		super(i, j, vel);
	}

	public Manual(int i, int j, char c) {
		super(i, j, c);
	}

	public Manual(int i, int j, char c, int vel) {
		super(i, j, c, vel);
	}

	public boolean addLlave(Key key) {
		if (this.key == null) {
			if(key.presionar(this)){
				this.key = key;
				return true;
			}
		}
		return false;
	}

	public boolean usarLlave() {
		if (key == null)
			return false;
		key = null;
		return true;
	}

	public boolean tengoLlave() {
		return key != null;
	}

}
