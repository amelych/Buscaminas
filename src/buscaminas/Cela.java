package buscaminas;

/**
 *
 * @author a20amelych
 */
public class Cela {

    private boolean minada;
    private int estado;
    private int fila;
    private int columna;

    /**
     * O constructor de Cela nos da toda a información sobre cada cela do
     * programa
     *
     * @estado int que indica o estado da cela. Tapada(1), marcada(2), destapada(3)
     * @param fila número da fila na que está colocada a cela.
     * @param columna número da columna na que está colocada a cela.
     * @minada un booleano que indica se a cela ten una mina ou non
     */
    public Cela(int fila, int columna, boolean minada) {
        this.estado = 1;
        this.fila = fila;
        this.columna = columna;
        this.minada = minada;
    }

    public boolean isMinada() {
        return minada;
    }

    public void setMinada(boolean minada) {
        this.minada = minada;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
   
}
