package uniminuto.POO.lupinIII.model.componentes;

import uniminuto.POO.lupinIII.model.Direccion;
import uniminuto.POO.lupinIII.model.Tablero;

public abstract class Dinamico extends Componente {

	private int vel;
	
	public Dinamico(int i, int j) {
		this(i, j, 1);
	}
	
	public Dinamico(int i, int j, char c) {
		this(i, j, c, 1);
	}
	
	public Dinamico(int i, int j, int vel) {
		super(i, j);
		this.vel = vel;
	}
	
	public Dinamico(int i, int j, char c, int vel) {
		super(i, j, c);
		this.vel = vel;
	}
	
	public int getVel(){
		return vel;
	}
	
	private boolean mover(int i, int j){
		this.i = i;
		this.j = j;
		return true;
	}
	
	public boolean mover(Direccion d, Tablero t){
		if(!t.movimientoPosible(this, d)) return false;
		int ni = i + d.getDi() * vel;
		int nj = j + d.getDj() * vel;
		mover(ni, nj);
		return true;
	}
        
        public boolean moverOrigen(Tablero t){
		int ni = 1;
		int nj = 1;
		mover(ni, nj);
                return true;
	}}
