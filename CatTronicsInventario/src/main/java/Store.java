import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Store {
    public static void main (String[] args) {
        Inventory inventory = new Inventory();
        methods m = new methods();
        inventory.addProduct(new Product("Z01","Laptop",15,1300000.00));
        inventory.addProduct(new Product("B01","Mouse",50,50000.00));
        inventory.addProduct(new Product("A01","Keyboard",30,100000.00));
        inventory.addProduct(new Product("A02","Monitor",10,500000.00));

        inventory.addReposition(new Product("A08","Microphone",5,100000.00));           //creamos la reposición de un prodcuto
        //inventory.proccessReposition();                                                                              //procesamos la reposición con los metodos creados en la clase inventory

        inventory.addDevolucion(new Product("A09","Speaker",10,200000.00));
        //inventory.proccessDevolucion();

        m.insertionSort(inventory.products);//Ordenamos para usarla =)

        int selectOption;
        /*BOTONES*/ String[] buttons = new String[]{"Lista de productos","Buscar Producto","Procesar Devolución","Procesar Repos","Salir"};
        do{
        selectOption = JOptionPane.showOptionDialog(null,"Bienvenido\nSeleccion una de las siguientes opciones ","CatTronics",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,m.icon,buttons,buttons[0]);
        switch (selectOption) {
            case 0:
                inventory.showInventory();
                break;
            case 1:
                String prodBuscado = JOptionPane.showInputDialog("Ingrese el codigo del producto a buscar");
                Product product = inventory.products.stream()
                        .filter(p -> p.getCode().equals(prodBuscado))
                        .findFirst()
                        .orElse(null);
                if (product == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró el producto");
                } else {
                    String[] buttonsBuy= new String[]{"Sí","No"};
                    int venta= JOptionPane.showOptionDialog(null, "Producto: "+product.getDescription()+
                            "\nUnidades disponibles: \n"+product.getStock()+
                            "\nPrecio: "+product.getPrice()+"$"+
                            "\n¿Desea realizar la compra?\n","tittle",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttonsBuy,buttonsBuy[0]);
                    if(venta == JOptionPane.YES_OPTION){
                        if(product.getStock()<=0){
                            JOptionPane.showMessageDialog(null,"No hay existencias de este producto");
                            break;
                        }
                        int cuantos= Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos desea comprar?"));
                        if(cuantos>product.getStock()){
                            JOptionPane.showMessageDialog(null,"No hay suficientes existencias");
                            break;
                        }
                        product.setStock(product.getStock() - cuantos); //Disminuimos la cantidad en 1 de la venta, el -poll() no reduce las unidades
                        JOptionPane.showMessageDialog(null,"Compraste"+ cuantos + "con éxito\nGRACIAS");
                    }else{
                        continue;
                    }
                }
                break;
                case 2:
                inventory.proccessDevolucion();    
                break;
                case 3:
                inventory.proccessReposition();
                break;
                case 4:
                JOptionPane.showMessageDialog(null, "Gracias por tu visita (=", "CatTronics", JOptionPane.INFORMATION_MESSAGE,m.icon);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
        }while (selectOption!=4);
    }
}
