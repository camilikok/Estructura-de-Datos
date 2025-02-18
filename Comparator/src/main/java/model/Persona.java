package model;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombreP, int edadP) {
        this.nombre = nombreP;
        this.edad = edadP;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
