package uniminuto.POO.lupinIII.model;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import uniminuto.POO.lupinIII.model.componentes.Automatico;
import uniminuto.POO.lupinIII.model.componentes.Bloqueador;
import uniminuto.POO.lupinIII.model.componentes.Componente;
import uniminuto.POO.lupinIII.model.componentes.Desbloqueable;
import uniminuto.POO.lupinIII.model.componentes.Dinamico;
import uniminuto.POO.lupinIII.model.componentes.Push;
import uniminuto.POO.lupinIII.model.componentes.enemigos.Enemigo;
import uniminuto.POO.lupinIII.model.componentes.estaticos.Estatico;
import uniminuto.POO.lupinIII.model.componentes.ladrones.Manual;
import uniminuto.POO.lupinIII.model.componentes.llaves.Key;
import uniminuto.POO.lupinIII.model.componentes.tesoros.Tesoro;
import uniminuto.POO.lupinIII.model.exceptions.ArchivoCorruptoException;

public class Tablero {

    private Estatico[][] mEst;
    private Dinamico[] vDin;
    private Manual ladron;
    private Tesoro tesoro;

    public Tablero(String path) throws FileNotFoundException,
            ArchivoCorruptoException {
        File f = new File(path);
        if (f.exists()) {
            Scanner in = new Scanner(f);
            try {
                int fils = in.nextInt();
                int cols = in.nextInt();
                mEst = new Estatico[fils][cols];
                String line;
                for (int i = 0; i < fils; ++i) {
                    line = in.next();
                    for (int j = 0; j < line.length(); ++j) {
                        Componente caux = Componente.obtenerComponente(line.charAt(j), i, j);
                        if (!(caux instanceof Estatico) && caux != null) {
                            throw new ArchivoCorruptoException(
                                    "Objeto no estatico");
                        } else {
                            mEst[i][j] = (Estatico) caux;
                        }
                    }
                }
                int nDin = in.nextInt();
                vDin = new Dinamico[nDin];
                for (int k = 0; k < nDin; ++k) {
                    char c = in.next().charAt(0);
                    int i = in.nextInt();
                    int j = in.nextInt();
                    if (estaPorFuera(i, j)) {
                        throw new ArchivoCorruptoException(
                                "Objeto Dinamico por Fuera");
                    }
                    if (mEst[i][j] == null) {
                        throw new ArchivoCorruptoException(
                                "Objeto Dinamico encima de null");
                    }
                    if (mEst[i][j] instanceof Bloqueador) {
                        throw new ArchivoCorruptoException(
                                "Objeto Dinamico encima de Bloqueador");
                    }
                    Componente caux = Componente.obtenerComponente(c, i, j);
                    if (caux == null) {
                        throw new ArchivoCorruptoException(
                                "Objeto Dinamico nulo");
                    }
                    for (int w = 0; w < k; ++w) {
                        if (caux.estaEncima(vDin[w])) {
                            throw new ArchivoCorruptoException(
                                    "Objetos dinamicos sobrelapados");
                        }
                    }
                    if (caux instanceof Dinamico) {
                        vDin[k] = (Dinamico) caux;
                    } else {
                        throw new ArchivoCorruptoException("Objeto no Dinamico");
                    }
                    if (vDin[k] instanceof Manual) {
                        if (ladron != null) {
                            throw new ArchivoCorruptoException(
                                    "Mas de un ladron");
                        }
                        ladron = (Manual) vDin[k];
                    }
                    if (vDin[k] instanceof Tesoro) {
                        if (tesoro != null) {
                            throw new ArchivoCorruptoException(
                                    "Mas de un tesoro");
                        }
                        tesoro = (Tesoro) vDin[k];
                    }
                }
                if (ladron == null || tesoro == null) {
                    throw new ArchivoCorruptoException(
                            "No se creo ladron o tesoro");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new FileNotFoundException("El archivo no existe");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mEst.length; ++i) {
            for (int j = 0; j < mEst[0].length; ++j) {
                Componente cEst = mEst[i][j];
                if (cEst == null) {
                    sb.append(" ");
                } else {
                    sb.append(cEst.toString());
                }
            }
            sb.append("\n");
        }
        for (int k = 0; k < vDin.length; ++k) {
            int aux = vDin[k].getI() * (mEst[0].length + 1) + vDin[k].getJ();
            if (vDin[k] instanceof Push) {
                if (!((Push) vDin[k]).estaPresionado()) {
                    sb.setCharAt(aux, vDin[k].getChar());
                }
            }
        }
        for (int k = 0; k < vDin.length; ++k) {
            int aux = vDin[k].getI() * (mEst[0].length + 1) + vDin[k].getJ();
            if (vDin[k] instanceof Manual) {
                sb.setCharAt(aux, vDin[k].getChar());
            }
        }
        for (int k = 0; k < vDin.length; ++k) {
            int aux = vDin[k].getI() * (mEst[0].length + 1) + vDin[k].getJ();
            if (vDin[k] instanceof Automatico) {
                sb.setCharAt(aux, vDin[k].getChar());
            }
        }
        return sb.toString();
    }

    public Class getClass(int i, int j) {
        for (int k = 0; k < vDin.length; ++k) {
            if (vDin[k].getI() == i && vDin[k].getJ() == j) {
                if (vDin[k] instanceof Automatico) {
                    return vDin[k].getClass();
                }
            }
        }
        for (int k = 0; k < vDin.length; ++k) {
            if (vDin[k].getI() == i && vDin[k].getJ() == j) {
                if (vDin[k] instanceof Manual) {
                    return vDin[k].getClass();
                }
            }
        }
        for (int k = 0; k < vDin.length; ++k) {
            if (vDin[k].getI() == i && vDin[k].getJ() == j) {
                if (vDin[k] instanceof Push) {
                    if (!((Push) vDin[k]).estaPresionado()) {
                        return vDin[k].getClass();
                    }
                }
            }
        }
        return mEst[i][j].getClass();
    }

    public boolean terminoJuego() {
        return gano() || perdio();
    }

    public boolean gano() {
        return ladron.estaEncima(tesoro);
    }

    public int getWidth() {
        return mEst[0].length;
    }

    public int getHeight() {
        return mEst.length;
    }

    public boolean perdio() {
        for (Dinamico c : vDin) {
            if (c instanceof Enemigo) {
                if (c.estaEncima(ladron)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean movimientoPosible(Dinamico c, Direccion d) {
        if (d == null) {
            return false;
        }
        for (int k = 1; k <= c.getVel(); ++k) {
            int ni = c.getI() + d.getDi() * k;
            int nj = c.getJ() + d.getDj() * k;
            if (estaPorFuera(ni, nj)) {
                return false;
            }
            if (mEst[ni][nj] == null) {
                return false;
            }
            if (mEst[ni][nj] instanceof Bloqueador) {
                if (((Bloqueador) mEst[ni][nj]).estaBloqueada()) {
                    return false;
                }
            }
            for (Dinamico od : vDin) {
                if (od instanceof Bloqueador) {
                    if (od.getI() == ni && od.getJ() == nj) {
                        if (od instanceof Desbloqueable) {
                            return ((Desbloqueable) od).sePuedeDesbloquear(c);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean estaPorFuera(int i, int j) {
        return i < 0 || j < 0 || i >= mEst.length || j >= mEst[0].length;
    }

    public boolean moverLadron(Direccion d) {
        if (moverAutomaticos()) {
            return false;
        }
        if (ladron.mover(d, this)) {
            buscarPresionados();
            return true;
        }
        return false;
    }

    private boolean buscarPresionados() {
        for (Dinamico c : vDin) {
            if (c instanceof Push) {
                if (ladron.estaEncima(c)) {
                    if (c instanceof Key) {
                        ladron.addLlave((Key) c);
                    } else {
                        ((Push) c).presionar(ladron);
                    }
                }
            }
        }
        return perdio();
    }

    private boolean moverAutomaticos() {
        for (Dinamico c : vDin) {
            if (c instanceof Automatico) {
                ((Automatico) c).mover(this);
            }
        }
        return perdio();
    }

    public Manual getLadron() {
        return ladron;
    }
}
