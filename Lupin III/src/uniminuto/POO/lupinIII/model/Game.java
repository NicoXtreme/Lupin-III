package uniminuto.POO.lupinIII.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import uniminuto.POO.lupinIII.model.exceptions.ArchivoCorruptoException;

public class Game {

    public static void main(String[] args) {
        Tablero t;
        Scanner in = new Scanner(System.in);
        try {
            t = new Tablero(Game.class.getResource("/uniminuto/POO/lupinIII/games/lupinIII.txt")
                    .getPath().replaceAll("%20", " "));
            while (!t.terminoJuego()) {
                System.out.println(t);
                System.out.println("Direccion:");
                Direccion d = Direccion.getDireccion(in.nextInt());
                t.moverLadron(d);
            }
            System.out.println(t);
            if (t.gano()) {
                System.out.println("Felicitaciones!!!");
            } else {
                System.out.println("Capturado!!!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArchivoCorruptoException e) {
            e.printStackTrace();
        }
    }
}
