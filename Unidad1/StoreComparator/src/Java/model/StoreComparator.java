package model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdk.jshell.execution.Util;
import utilities.utilities;

public class StoreComparator {
    public static void main(String[] args) throws Exception {

        ArrayList<Product> Products = new ArrayList<>();
        Products.add(new Product("Papas", 100, 1.000));
        Products.add(new Product("Manzanas", 32, 2.500));
        Products.add(new Product("Naranjas", 1, 3.500));
        Products.add(new Product("Peras", 96, 4.500));
        Products.add(new Product("Uvas", 7, 5.500));
        Products.add(new Product("Fresas", -6, 6.500));
        Products.add(new Product("Sandias", 0, 7.500));
        Products.add(new Product("Melones", 001, 8.500));
        Products.add(new Product("Platanos", 01, 9.500));
        Products.add(new Product("Mangos", 10, 10.500));

        utilities util = new utilities(Products); //llamo estancia para aplicar metodos

        String[] options = new String[]{"Desordenados", "Inserción", "Burbuja","Buscar Producto", "Salir"};
        int selectedOption;
        do {
            selectedOption = JOptionPane.showOptionDialog(null, "Bienvenido, aqui podrá consultar productos y comparar precios\nSeleccione la opción que desea realizar",
                    "MERCADOCHO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (selectedOption) {
                case 0:
                    System.out.println("Lista de productos sin ordenamiento: \n");
                    for (Product p : Products) {
                        System.out.println("Nombre: " + p.getDescription() + "  Id: " + p.getId() + "  Precio: " + p.getPrice());
                    }
                    break;
                case 1:
                    ArrayList<Product> ProductsInsersion = new ArrayList<>(Products); //copia para que no altere los demas casos
                    util.insertionSort(ProductsInsersion);
                    System.out.println("Lista Ordenada por inserción: \n");
                    for (Product p : ProductsInsersion) {
                        System.out.println("Nombre: " + p.getDescription() + "  Id: " + p.getId() + "  Precio: " + p.getPrice());
                    }
                    break;
                case 2:
                    ArrayList<Product> ProductsBubble = new ArrayList<>(Products); //Copia
                    util.bubbleSort(ProductsBubble);
                    util.showProducts("Ordenado por burbuja =)", ProductsBubble);
                    break;
                case 3:
                    ProductsBubble = new ArrayList<>(Products); //llamo la lista de nuevo en este caso
                    util.bubbleSort(ProductsBubble); //ordeno la lista
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a buscar"));
                    int index = util.binarySearch(ProductsBubble, id);
                    JOptionPane.showMessageDialog(null,"Producto encontrado en la posición: " + index);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo..");
                    break;
            }
        } while (selectedOption != 4);
    }
}


