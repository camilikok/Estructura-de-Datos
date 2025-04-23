public class Palabra {
    private String descripcion;
    private String significado;
    Palabra izquierda,derecha;

    public Palabra(String descripcion, String significado) {
        this.descripcion = descripcion;
        this.significado = significado;
        izquierda = derecha = null;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getSignificado() {
        return significado;
    }
    public void setSignificado(String significado) {
        this.significado = significado;
    }
    public Palabra getIzquierda() {
        return izquierda;
    }
    public void setIzquierda(Palabra izquierda) {
        this.izquierda = izquierda;
    }
    public Palabra getDerecha() {
        return derecha;
    }
    public void setDerecha(Palabra derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "descripcion='" + descripcion + '\'' +
                ", significado='" + significado + '\'' +
                '}';
    }
}
