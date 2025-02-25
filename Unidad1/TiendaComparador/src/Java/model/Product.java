package model;

public class Product implements Comparable<Product> {
    String description;
    int id;
    double price;

    public Product(String descriptionP, int idP, double priceP) {
        this.description = descriptionP;
        this.id = idP;
        this.price = priceP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toInfoProduct() {
        return "Nombre: " + description + ", ID: " + id + ", Precio: " + price;
    }
    @Override
    public int compareTo(Product otherProduct) {
        return this.description.compareTo(otherProduct.getDescription());
    }

}