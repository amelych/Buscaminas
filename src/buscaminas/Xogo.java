package buscaminas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author a20amelych
 */
public class Xogo {

    public Scanner teclado = new Scanner(System.in, "ISO-8859-1");
    private int filas;
    private int columnas;
    private Cela[][] celas;
    private boolean vivo;
    private ArrayList<Cela> celasAdxacentes;
    private Vista vista;

    public Xogo(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celas = new Cela[filas][columnas];
        this.vivo = true;
        vista = new Vista();
        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas[i].length; j++) {
                celas[i][j] = new Cela(i, j, false);
            }
        }
        encherMinas(minas);
    }

    public Cela[][] getCelas() {
        return celas;
    }

    public void setCelas(Cela[][] celas) {
        this.celas = celas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void imprimirPanel() {
        System.out.print("\t");
        for (int i = 0; i < celas.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < celas.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < celas[i].length; j++) {
                switch (celas[i][j].getEstado()) {
                    case 1 -> System.out.print("[" + "-" + "]");
                    case 2 -> System.out.print("[" + "!" + "]");
                    case 3 -> {
                        if (celas[i][j].isMinada() == true) {
                            System.out.print(vista.BLACK_ON_RED + "[" + "*" +"]" + vista.RESET);
                        } else {
                            axudaUsuario(celas[i][j]);
                        }
                    }
                    default -> {
                    }
                }
            }
            System.out.println();
        }
    }

    private void axudaUsuario(Cela cela) {
        switch (getMinasAdxacentes(cela)) {
            case 1 ->
                System.out.print("[" + vista.CYAN + "1" + vista.RESET + "]");
            case 2 ->
                System.out.print("[" + vista.GREEN + "2" + vista.RESET + "]");
            case 3 ->
                System.out.print("[" + vista.RED + "3" + vista.RESET + "]");
            case 4 ->
                System.out.print("[" + vista.PURPLE + "4" + vista.RESET + "]");
            case 5 ->
                System.out.println("[" + vista.YELLOW + "5" + vista.RESET + "]");
            case 6 ->
                System.out.println("[" + vista.CYAN + "6" + vista.RESET + "]");
            case 7 ->
                System.out.println("[" + vista.BLACK + "7" + vista.RESET + "]");
            case 8 ->
                System.out.println("[" + vista.RED + "8" + vista.RESET + "]");
            default ->
                System.out.print("[" + " " + "]");
        }
    }

    public Cela getCela(int fila, int columna) {
        return celas[fila][columna];
    }

    private ArrayList<Cela> getCelasAdxacentes(Cela cela) {
        celasAdxacentes = new ArrayList<>();
        int fila = cela.getFila();
        int columna = cela.getColumna();
        for (int i = fila - 1; i <= fila + 1; i++) {
            if (i >= 0 && i < celas.length) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (j >= 0 && j < celas[i].length && !celas[i][j].equals(cela)) {
                        celasAdxacentes.add(celas[i][j]);
                    }
                }
            }
        }
        return celasAdxacentes;
    }

    public int getMinasAdxacentes(Cela cela) {
        int mina = 0;
        for (Cela celaAdxacente: getCelasAdxacentes(cela)) {
            if (celaAdxacente.isMinada()) {
                mina++;
            }
        }
        return mina;
    }

    public void abrirCela(Cela cela) {
        if (celas[cela.getFila()][cela.getColumna()].isMinada() == true) {
            setVivo(false);
            vista.partidaPerdida();
            abrirTodasMinas();
            imprimirPanel();
        } else {
            cela.setEstado(3);
            if (getMinasAdxacentes(cela) == 0) {
                for (int i = 0; i < getCelasAdxacentes(cela).size(); i++) {
                    if (getCelasAdxacentes(cela).get(i).getEstado() == 1) {
                        abrirCela(getCelasAdxacentes(cela).get(i));
                    }
                }
            }
        }
    }

    public void marcarCela(Cela cela) {
        if (celas[cela.getFila()][cela.getColumna()].getEstado() == 3) {
            vista.celaDestapada();
        } else {
            cela.setEstado(2);
        }
    }

    public void abrirTodasMinas() {
        if (vivo == false) {
            for (int i = 0; i < celas.length; i++) {
                for (int j = 0; j < celas[i].length; j++) {
                    if (celas[i][j].isMinada() == true) {
                        celas[i][j].setEstado(3);
                    }
                }
            }
        }
    }

    public boolean comprobarCelasAbrir() {
        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas[i].length; j++) {
                if (celas[i][j].isMinada() == false && celas[i][j].getEstado() == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void encherMinas(int minas) {
        int contador = 0;
        Random r = new Random();
        while (contador < minas) {
            int fila = r.nextInt(filas);
            int columna = r.nextInt(columnas);
            if (celas[fila][columna].isMinada() == false) {
                celas[fila][columna].setMinada(true);
                contador++;
            }
        }
    }

    public void juegoGanado() {
        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas[i].length; j++) {
                if (celas[i][j].isMinada() == true && celas[i][j].getEstado() == 1) {
                    celas[i][j].setEstado(2);
                }
            }
        }
        vista.mostrarMenu();
        imprimirPanel();
        vista.partidaGanada();
    }
}
