package shop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 


public class Product {
    
    //VARIABLES

    private String name;
    private double price;
    private int quantity;

    private int size;
    private String color;

    private static ArrayList<Product> inventory;

    //CONSTRUCTORS

    public Product() {
        Product.inventory = new ArrayList<Product>();
    }

    public Product(String name, double price, int quantity, int size) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;

        inventory.add(this);
    }

    public Product(String name, double price, int quantity,String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;

        inventory.add(this);
    }

    public Product(String name, double price, int quantity, int size, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.color = color;

        inventory.add(this);
    }

    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void getInventory(String name) {
        Collections.sort(inventory);
        if (name == "all") {
            getInventory();
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).name == name) {
                    System.out.println("#" + i + ": " + inventory.get(i).toString());
                }
            }
        }
    }

    public static void getInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("#" + i + ": " + inventory.get(i).toString());
        }
    }
    //TO STRING METHOD

    @Override
    public String toString() {
        return "Product [name=" + name + "| price=" + price + "| quantity=" + quantity + "| size=" + size + "| color="
                + color + "]";
    }

}
