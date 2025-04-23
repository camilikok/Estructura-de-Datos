import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class Diccionario {
    private Palabra raiz;

    public Diccionario() {
        this.raiz = null;
    }

    public void agregarPalabra(String descripcion, String significado) {
        raiz = agregarPalabraRec(raiz, descripcion, significado);
    }

    public String buscarPalabra(String descripcion) {
        return buscarPalabraRec(raiz, descripcion);
    }

    public void mostrarPalabraOrdenado() {
        mostrarEnOrden(raiz);
    }

    private Palabra agregarPalabraRec(Palabra actual, String descripcion, String significado) {
        if (actual == null)
            return new Palabra(descripcion, significado);
        if (descripcion.compareToIgnoreCase(actual.getDescripcion()) < 0)
            actual.setIzquierda(agregarPalabraRec(actual.getIzquierda(), descripcion, significado));
        else if (descripcion.compareToIgnoreCase(actual.getDescripcion()) > 0)
            actual.setDerecha(agregarPalabraRec(actual.getDerecha(), descripcion, significado));
        else actual.setSignificado(significado);
        return actual;
    }


    private String buscarPalabraRec(Palabra actual, String descripcion) {
        if (actual == null) return null;
        if (descripcion.equalsIgnoreCase(actual.getDescripcion()))
            return actual.getSignificado();
        return (descripcion.compareToIgnoreCase(actual.getDescripcion()) < 0)
                ? buscarPalabraRec(actual.getIzquierda(), descripcion)
                : buscarPalabraRec(actual.getDerecha(), descripcion);
    }

    private void mostrarEnOrden(Palabra actual){
        if(actual != null ){
            mostrarEnOrden(actual.getIzquierda());
            JOptionPane.showMessageDialog(null,actual.getDescripcion());
            mostrarEnOrden(actual.getDerecha());
        }
    }
}

