import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;

public class methods {

    Product product = new Product();

    class compatorForPrice implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p1.getPrice(), p2.getPrice());
        }
    }

    public static int binarySearch(LinkedList<Product> productsList, String code) {
        int inicio = 0;
        int fin = productsList.size() - 1;

        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            String midCode = productsList.get(mitad).getCode();
            int comparacion = code.compareTo(midCode);
            if (comparacion == 0) {
                return mitad;
            } else if (comparacion > 0) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }
        }
        return -1;
    }

    public static void insertionSort(LinkedList<Product> productsList) {
        int n = productsList.size();
        for (int i = 1; i < n; i++) {
            Product key = productsList.get(i);
            int j = i - 1;

            // Compara los internalCode usando compareTo() de String
            while (j >= 0 && productsList.get(j).getCode().compareTo(key.getCode()) > 0) {
                productsList.set(j + 1, productsList.get(j));
                j = j - 1;
            }

            productsList.set(j + 1, key);
        }
    }

    ImageIcon icon = new ImageIcon("src/main/resources/KtronicIcon.jpeg");

}



