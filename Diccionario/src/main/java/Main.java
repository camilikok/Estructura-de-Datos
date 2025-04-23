import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("abierto", "del verbo abrir");
        diccionario.agregarPalabra("cerrado", "del verbo cerrar");
        diccionario.agregarPalabra("el verbo", "del verbo");
        diccionario.agregarPalabra("viendo", "del verbo ver");
        diccionario.agregarPalabra("jugando", "del verbo jugar");

        diccionario.buscarPalabra("abierto");
        int seleccion;
        do {
            seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea realizar: \n 1)Agregar Palabra\n2)Buscar significado\n3)Ver las palabras"));
            switch (seleccion) {
                case 1:
                    String descripcion = JOptionPane.showInputDialog(null,"Ingrese la palabra");
                    String significado = JOptionPane.showInputDialog(null,"Ingrese su significado");
                    diccionario.agregarPalabra(descripcion, significado);
                    break;
                case 2:
                    String buscada = JOptionPane.showInputDialog("Ingrese la palabra que desea buscar");
                    String resultado = diccionario.buscarPalabra(buscada);
                    if (resultado != null) {
                        JOptionPane.showMessageDialog(null, "Significado: " + resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la palabra");
                    }
                    break;
                case 3:
                    diccionario.mostrarPalabraOrdenado();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida");
            }
        } while (seleccion != 4);
    }
}
