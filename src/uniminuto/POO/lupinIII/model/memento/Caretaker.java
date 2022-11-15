package uniminuto.POO.lupinIII.model.memento;


//import java.util.ArrayList;

public class Caretaker {

	/*private ArrayList<Memento> mementos = new ArrayList<>();*/
    
        private Memento checkpoint;

	public void addMemento(Memento m) {
		/*mementos.add(m);*/
                this.checkpoint=m;
	}

	public Memento getMemento() {
		//return mementos.get(index);
                return checkpoint;
	}
}
