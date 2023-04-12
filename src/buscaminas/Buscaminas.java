package buscaminas;

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
        Xogo x = new Xogo(6, 6, 4);
        Vista pruebas = new Vista();
        boolean continuar = x.isVivo();
        int eleccion = 0;
        int fila = 0;
        int columna = 0;
        
        do {
            System.out.println("-----------------Menu-----------------");
            System.out.println("1. Escolle a cela a destapar (fila e columna)");
            System.out.println("2. Marcar unha cela.");
            System.out.println("3. salir");
            x.imprimirPanel();
            eleccion = teclado.nextInt();
            switch (eleccion) {
                case 1 -> {
                    System.out.println("Escribe a fila: ");
                    fila = teclado.nextInt();
                    System.out.println("Escribe a columna: ");
                    columna = teclado.nextInt();                    
                    x.abrirCela(x.getCela(fila, columna));
                    if (x.getCela(fila, columna).isMinada()) {
                        continuar = x.isVivo();
                    } else if (x.comprobarCelasAbrir() == true) {
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
        } while (continuar);
    }
}
