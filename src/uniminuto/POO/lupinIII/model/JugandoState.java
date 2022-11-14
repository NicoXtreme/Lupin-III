package uniminuto.POO.lupinIII.model;

import lupinIII.menu.SeleccionNivel;

/**
 *
 * @author NicoXtreme
 */
public class JugandoState extends State{

    public JugandoState(SeleccionNivel user){
        user.setJugando(true);
    }
    
    
    @Override
    public String jugando() {
        user.changeState(new JugandoState(user));
        return "El usuario está jugando";
    }

    @Override
    public String noJugando() {
        user.changeState(new JugandoState(user));
        return "El usuario no está jugando";
    }
    
    
}
