package uniminuto.POO.lupinIII.model.componentes.puertas;

import uniminuto.POO.lupinIII.model.componentes.llaves.Key;

public interface AbridorPuertaBlock {

	public boolean addLlave(Key key);
	
	public boolean usarLlave();
	
	public boolean tengoLlave();
	
}
