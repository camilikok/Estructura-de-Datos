package utilities;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class utilities {
    private List<Product> products;

    public utilities(ArrayList<Product> products) {
        this.products = new ArrayList<>();
    }

    public void showProducts(String title, List<Product> products) {
        StringBuilder message = new StringBuilder(title + "\n\n");
        for (Product product : products) {
            message.append("Nombre: ").append(product.getDescription()).append("\n");
            message.append("ID: ").append(product.getId()).append("\n");
            message.append("Precio: ").append(product.getPrice()).append("\n\n");
        }
        // Crear un JTextArea con el texto
        JTextArea textArea = new JTextArea(message.toString());
        textArea.setLineWrap(true); // Ajusta líneas largas
        textArea.setWrapStyleWord(true);
        // Crear un JScrollPane para manejar la visualización
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 500)); // Dimensiones RECTANGULARES
        // JPanel para el JScrollPane y a la mitad
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana emergente con dimensiones fijas
        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void insertionSort(List<Product> Products) {
        int n = Products.size();
        for (int i = 1; i < n; i++) {
            Product key = Products.get(i);
            int j = i - 1;
            while (j >= 0 && Products.get(j).getId() > key.getId()) {
                Products.set(j + 1, Products.get(j));
                j = j - 1;
            }
            Products.set(j + 1, key);
        }
    }

    public static void bubbleSort(List<Product> Products) {
        int n = Products.size();
        boolean change;
        for (int i = 0; i < n - 1; i++) {
            change = false;

            for (int j = 0; j < n - 1 - i; j++) {
                //compara elementos de los lados
                if (Products.get(j).compareTo(Products.get(j + 1)) > 0) {
                    //intercamcbio
                    Product aux = Products.get(j);
                    Products.set(j, Products.get(j + 1));
                    Products.set(j + 1, aux);
                    change = true;
                }
            }
        }
    }

    public static int binarySearch(List<Product> products, int id) {
        int low = 0, high = products.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //partir la lista a la mitad
            if (products.get(mid).getId() == id) {
                return mid; //si se encuentra se devuelve mid
            }
            if (products.get(mid).getId() < id) {
                low = mid + 1; //si el indice buscado es < mid se busca en la mitad derecha
            } else {
                high = mid - 1; //si el indice buscado es > mid se busca en la mitad izquierda
            }
        }
        return -1;
    }
}


