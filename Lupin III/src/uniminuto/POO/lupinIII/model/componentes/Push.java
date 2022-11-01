package uniminuto.POO.lupinIII.model.componentes;


public abstract class Push extends Dinamico {
	
	protected boolean fPush;
	
	public Push(int i, int j) {
		this(i, j, false);
	}
	
	public Push(int i, int j, char c) {
		this(i, j, c, false);
	}
	
	public Push(int i, int j, boolean fPush) {
		super(i, j);
		this.fPush = fPush;
	}
	
	public Push(int i, int j, char c, boolean fPush) {
		super(i, j, c);
		this.fPush = fPush;
	}
	
	public boolean estaPresionado(){
		return fPush;
	}
	
	public boolean presionar(Dinamico d){
		fPush = !fPush;
		return fPush;
	}

}
