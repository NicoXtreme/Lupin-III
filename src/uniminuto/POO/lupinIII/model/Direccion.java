package uniminuto.POO.lupinIII.model;

import java.util.Random;

public enum Direccion {

	STOP(0,0), ARRIBA(-1,0), ABAJO(1,0), DERECHA(0,1), IZQUIERDA(0,-1), 
	ARR_IZQ(-1,-1), ARR_DER(-1,1), ABA_IZQ(1,-1), ABA_DER(1,1);
	
	private int di;
	private int dj;
	
	private Direccion(int di, int dj){
		this.di = di;
		this.dj = dj;
	}
	
	public int getDi(){
		return di;
	}
	
	public int getDj(){
		return dj;
	}
	
	public static Direccion azar(){
		return azar(false, false);
	}
	
	public static Direccion azar(boolean flagStop, boolean flagDiagonales){
		Random r = new Random();
		int vstop = flagStop?0:1;
		int max = flagDiagonales?9:5;
		return getDireccion(r.nextInt(max-vstop)+vstop);
	}
	
	public static Direccion getDireccion(int i){
		if(i == 0) return STOP;
		else if(i == 1) return ARRIBA;
		else if(i == 2) return ABAJO;
		else if(i == 3) return DERECHA;
		else if(i == 4) return IZQUIERDA;
		else if(i == 5) return ARR_DER;
		else if(i == 6) return ARR_IZQ;
		else if(i == 7) return ABA_DER;
		else if(i == 8) return ABA_IZQ;
		else return null;
	}
	
}
