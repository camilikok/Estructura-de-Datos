import java.util.LinkedList;

public class Product implements Comparable<Product> {
    private String code;
    private String Description;
    private int stock;
    double price;

    public Product(String code, String Description, int stock, double price) {
        this.code = code;
        this.Description = Description;
        this.stock = stock;
        this.price = price;
    }

    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {           //codigo
        return this.code.compareTo(other.code);
    }
    public int compareTOStock(Product other) {      //cantidad
        return Integer.compare(this.stock, other.stock);
    }
    public int comparetoPrice(Product other) {    //precio
        return Double.compare(this.price, other.price);
    }


    public String toStringProducts() {
        return "\n - "+getDescription() +
                "\n codigo='" + code + '\'' +
                "\n Unidades Disponibles= " + stock +
                "\n price= " + price + "$\n" ;
    }
}

