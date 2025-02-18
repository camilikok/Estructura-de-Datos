package model;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*• PARA UNA COMPARACIÓN FIJA "CONSTANTE" DE ALGO UNICO
* • PARA ESTRUCTURAS LOGICAS COMO ARBOLES Y ESTRUCTURAS DE DATOS
* • NO TIENE VARIAS FORMAS DE ORDENAR
* • NO MODIFICA LA CLASE, FUNCIONA MAS COMO UN METODO
* • METODO= COMPARE(T O1, T O2)
* • ORDENA POR EDAD, APELLIDO ETC
* • UTIL CUANDO SE REQUIERE ORDENAR DE DIFERENTES MANERAS*/

class compararPorEdad implements Comparator<Persona>{
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getEdad() - p2.getEdad();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Ana", 30);
        Persona p3 = new Persona("Pedro", 10);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

        //aplicamos comparator
        Collections.sort(personas, new compararPorEdad());

        //  String con todo de una vez
        StringBuilder mensajeCompleto = new StringBuilder("Orden por edad:\n");
        for (Persona p : personas) {
            mensajeCompleto.append(p.getNombre()).append(" - ").append(p.getEdad()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensajeCompleto.toString());
    }
}