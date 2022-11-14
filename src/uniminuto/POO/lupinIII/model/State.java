package uniminuto.POO.lupinIII.model;

import lupinIII.menu.SeleccionNivel;

/**
 *
 * @author NicoXtreme
 */
public abstract class State {
    SeleccionNivel user;
    
    
    public State(){
        this.user = user;
    }
    
    public abstract String jugando();
    public abstract String noJugando();
}
