import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Inventory {
    public LinkedList<Product> products = new LinkedList<Product>();    //lista
    public Stack<Product> devolutions = new Stack<Product>();   //pila
    public Queue<Product> repositions = new LinkedList<Product>();  //cola

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addDevolucion(Product product) {
        devolutions.push(product);
    }
    public void removeDevolucion(Product product){
        devolutions.pop();
    }

    public void addReposition(Product product) {    //agrega al final
        repositions.offer(product);
    }
    public void removeReposition(Product product){ //remueve del frente
        repositions.poll();
    }

    public void proccessReposition() {
        if (!repositions.isEmpty()) {
            System.out.println("Procesando reposición: " + repositions.poll().getDescription());
        } else {
            System.out.println("No hay reposiciones pendientes");
        }
    }

    public void showInventory() {
        StringBuilder inventoryText = new StringBuilder();
        for (Product product : products) {
            inventoryText.append(product.toStringProducts()).append("\n");
        }
        JOptionPane.showMessageDialog(null, inventoryText);
    }

    public void showRepositions() {
        for (Product product : repositions) {
            JOptionPane.showMessageDialog(null, product.toStringProducts());
        }
    }
}
