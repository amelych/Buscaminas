package buscaminas;

import java.util.Scanner;

/**
 *
 * @author a20amelych
 */
public class Vista {

    Scanner teclado = new Scanner(System.in, "ISO-8859-1");
    
    public static final String RESET = "\u001B[0m"; // reset de colores
    public static final String BLUE = "\u001B[34m"; // para 1
    public static final String GREEN = "\u001B[32m"; // para 2
    public static final String RED = "\u001B[31m"; // para 3
    public static final String PURPLE = "\u001B[35m"; // para 4
    public static final String YELLOW = "\u001B[33m"; // para 5
    public static final String CYAN = "\u001B[36m"; // para 6
    public static final String BLACK = "\u001B[30m"; // para 7
    public static final String BLACK_ON_RED = "\u001B[41m"; // para 8


    public void mostrarMenu() {
        System.out.println("--------------------Menu--------------------");
        System.out.println("1. Escolle a cela a destapar (fila e columna)");
        System.out.println("2. Marcar unha cela.");
        System.out.println("3. salir");
        System.out.println("--------------------------------------------");
    }

    public void partidaGanada() {
        System.out.println(GREEN + "Juego ganado!!!!" + RESET);
    }

    public void partidaPerdida() {
        System.out.println(RED + "Abriste una mina" + RESET);
    }

    public void celaDestapada() {
        System.out.println(RED + "A cela xa estaba destapada" + RESET);
    }
    
    public void arrayExcepcion() {
        System.out.println(RED + "El número introducido no se encuentra dentro del array" + RESET);
    }
    
    public void excepcionMadre() {
        System.out.println(RED + "Ocurrió algún otro error" + RESET);
    }
    
    public void noInteger() {
        System.out.println(RED + "El elemento introducido no es un integer" + RESET);
    }
}
