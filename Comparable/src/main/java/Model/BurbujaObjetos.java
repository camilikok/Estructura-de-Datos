package Model;
import java.util.*;
/*• Debe estar en la misma clase
* • Define un orden natural para los objetos de la clase
* • modifica la clase por el compareTo
* • Se usa con colletions.sort
* • Ordena por nombre alfabeticamente
* */

class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombreP, int edadP) {
        this.nombre = nombreP;
        this.edad = edadP;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }

    // compareTo para ordenar por nombre
    @Override
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.getNombre());
    }
    @Override
    public String toString() {
        return nombre + ",Edad:" + edad;
    }
}

public class BurbujaObjetos  {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Camilito",24));
        personas.add(new Persona("Juan", 18));
        personas.add(new Persona("Isabella", 27));

        // Orden usando Comparable por nombr
        Collections.sort(personas); // Ordena por nombre solito
        System.out.println("Ordenado por Nombre:");
        //ciclo para imprimir todo el contenido de la lista
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}
