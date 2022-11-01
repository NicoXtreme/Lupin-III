package uniminuto.POO.lupinIII.model.componentes.enemigos;

import uniminuto.POO.lupinIII.model.Direccion;
import uniminuto.POO.lupinIII.model.Tablero;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Manual;

public interface Enemigo {

	public Direccion buscar(Manual ladron, Tablero t);
	
	public boolean mover(Manual ladron, Tablero t);
	
}
