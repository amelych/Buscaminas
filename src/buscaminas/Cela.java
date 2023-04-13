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
     * El constructor de la Cela nos da toda la información sobre cada cela del
     * programa
     *
     * @estado int que indica el estado de la cela. Tapada(1), marcada(2), destapada(3)
     * @param fila número de la fila en la que está colocada la cela.
     * @param columna número de la columna en la que está colocada la cela.
     * @param minada un booleano que indica si la cela tiene una mina o no
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cela other = (Cela) obj;
        if (this.fila != other.fila) {
            return false;
        }
        return this.columna == other.columna;
    }
   
}
