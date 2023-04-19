package buscaminas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author a20amelych
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        Xogo x = new Xogo(8, 8, 10);
        Vista vista = new Vista();
        
        boolean continuar = true;
        int eleccion = 0;
        int fila = 0;
        int columna = 0;

        do {
            try {
                vista.mostrarMenu();
                x.imprimirPanel();
                eleccion = teclado.nextInt();
                switch (eleccion) {
                    case 1 -> {
                        System.out.println("Escribe a fila: ");
                        fila = teclado.nextInt();
                        System.out.println("Escribe a columna: ");
                        columna = teclado.nextInt();
                        x.abrirCela(x.getCela(fila, columna));
                         if (x.comprobarCelasAbrir() == true) {
                            x.imprimirPanel();
                            x.juegoGanado();
                            continuar = false;
                        }
                    }
                    case 2 -> {
                        System.out.println("Escribe a fila: ");
                        fila = teclado.nextInt();
                        System.out.println("Escribe a columna: ");
                        columna = teclado.nextInt();
                        x.marcarCela(x.getCela(fila, columna));
                    }
                    case 3 -> {
                        System.out.println("Saíndo.....");
                        continuar = false;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                vista.arrayExcepcion();
            } catch (InputMismatchException e) {
                vista.noInteger();
                teclado.nextLine();
            } catch (Exception e) {
                vista.excepcionMadre();
                teclado.nextLine();
            }
        } while (x.isVivo() && continuar);
    }
}
