package uniminuto.POO.lupinIII.model.componentes;

import uniminuto.POO.lupinIII.model.componentes.enemigos.Perro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Muro;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Piso;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Ladron;
import uniminuto.POO.lupinIII.model.componentes.llaves.Key;
import uniminuto.POO.lupinIII.model.componentes.puertas.Puerta;
import uniminuto.POO.lupinIII.model.componentes.puertas.PuertaBlock;
import uniminuto.POO.lupinIII.model.componentes.tesoros.Tesoro;


public abstract class Componente {

	protected int i;
	protected int j;
	protected char c;
	
	public Componente(int i, int j){
		this(i,j, '?');
	}
	
	public Componente(int i, int j, char c){
		this.i = i;
		this.j = j;
		this.c = c;
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}
	
	public char getChar(){
		return c;
	}
	
	public boolean estaEncima(Componente comp){
		return i == comp.getI() && j == comp.getJ();
	}
	
	public static Componente obtenerComponente(char c, int i, int j){
		if(c == '#'){
			return new Muro(i,j);
		}else if(c == 'P'){
			return new Piso(i,j);
		}else if(c == 'L'){
			return new Ladron(i,j);
		}else if(c == '$'){
			return new Tesoro(i,j);
		}else if(c == '['){
			return new Puerta(i,j);
		}else if(c == 'K'){
			return new Key(i,j);
		}else if(c == '{'){
			return new PuertaBlock(i,j);
		}else if(c == 'D'){
			return new Perro(i,j);
		}
		return null;
	}
	
	public String toString(){
		return Character.toString(c);
	}
	
}
