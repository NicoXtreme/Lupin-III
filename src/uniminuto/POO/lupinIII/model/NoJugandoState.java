package uniminuto.POO.lupinIII.model;

import lupinIII.menu.SeleccionNivel;

/**
 *
 * @author NicoXtreme
 */
public class NoJugandoState extends State{
    
    public NoJugandoState(SeleccionNivel user){
        user.setJugando(false);
    }

    @Override
    public String jugando() {
        user.changeState(new JugandoState(user));
        return "El usuario no está jugando";
    }

    @Override
    public String noJugando() {
        user.changeState(new JugandoState(user));
        return "El usuario no está jugando";
    }
}
