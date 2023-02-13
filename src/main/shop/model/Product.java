package shop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class Product {
    
    //VARIABLES

    private String Productname;
    private double Productprice;
    private int quantity;

    private int size;
    private String Productdescription;
    private Product original;

    private static ArrayList<Product> inventory;

    //CONSTRUCTORS

    public Product() {
        Product.inventory = new ArrayList<Product>();
    }

    public Product( String name, int quanity) {
        this.Productname=name;
        this.quantity=quanity;
    }

    public Product(String name, double price, int quantity, int size) {
        this.Productname = name;
        this.Productprice = price;
        this.quantity = quantity;
        this.size = size;

        inventory.add(this);
    }

    public Product(String name, double price, int quantity,String color) {
        this.Productname = name;
        this.Productprice = price;
        this.quantity = quantity;
        this.Productdescription = color;

        inventory.add(this);
    }
    
    public Product(Product product) {
        this.Productname = product.Productname;
        this.Productprice = product.Productprice;
        this.size = product.size;
        this.Productdescription = product.Productdescription;
        this.original=product;
        this.quantity=product.quantity;
    }

    public Product(Product product, Product old) {
        this.Productname = product.Productname;
        this.Productprice = product.Productprice;
        this.size = product.size;
        this.Productdescription = product.Productdescription;
        this.original=old;
        this.quantity=product.quantity;
    }

    public Product(String name, double price, int quantity, int size, String color) {
        this.Productname = name;
        this.Productprice = price;
        this.quantity = quantity;
        this.size = size;
        this.Productdescription = color;

        inventory.add(this);
    }

    //GETTERS AND SETTERS

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String name) {
        this.Productname = name;
    }

    public double getProductprice() {
        return Productprice;
    }

    public void setProductprice(double price) {
        this.Productprice = price;
    }

    public int getProductQuantity() {
        return quantity;
    }
    
    public void setProductQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public Product getOriginal() {
        return original;
    }

    public void setOriginal(Product original) {
        this.original = original;
    }

    public static void sortInventory() {
        Collections.sort(inventory, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getProductname().compareTo(o2.getProductname());
            }
        });
    }

    public static void getInventory(String name) {
        sortInventory();
        if (name == "all") {
            getInventory();
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).Productname == name) {
                    System.out.println("#" + i + ": " + inventory.get(i).toString());
                }
            }
        }
    }

    public static void getInventory(int index) {
        sortInventory();
        if (index == 0) {
            getInventory();
        } else {
                    System.out.println("#" + index + ": " + inventory.get(index-1).toString());
                }
    }

    

    public static void getInventory() {
        sortInventory();
        System.out.println("---------------------------------------Inventory----------------------------------------");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("#" + (i+1) + ": " + inventory.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public static ArrayList<Product> IventoryList() {
        return inventory;
    }

    public void updateQuantity(int index, int quanity) {
        index=index-1;
        Product staging= inventory.get(index);
        if (staging.getProductQuantity()>quanity){
            staging.setProductQuantity(inventory.get(index).getProductQuantity() - quanity);
            System.out.println("Updated #" + (index + 1) + ": " + inventory.get(index).toString());
        } else {  System.out.println("Sorry we only have  "+staging.getProductQuantity()+" in stock.");}
        
    }

    public void updateInventory(int index, int quanity) {
        index = index - 1;
        Product staging = inventory.get(index);
        if((staging.getProductQuantity()-quanity)==0){
            inventory.remove(staging);
        }else if (staging.getProductQuantity() > quanity) {
            staging.setProductQuantity(inventory.get(index).getProductQuantity() - quanity);
            System.out.println("Updated #" + (index + 1) + ": " + inventory.get(index).toString());
        } else {
            System.out.println("Sorry we only have  " + staging.getProductQuantity() + " in stock.");
        }

    }

    public void updateQuantity(String Productname, int quanity) {
        Product staging = inventory.get(inventory.indexOf(Productname));
        if (staging.getProductQuantity() > quanity) {
            staging.setProductQuantity(inventory.get(inventory.indexOf(Productname)).getProductQuantity() - quanity);
            System.out.println("Updated #" + (inventory.indexOf(Productname) + 1) + ": " + inventory.get(
                    inventory.indexOf(Productname)).toString());
        } else {
            System.out.println("Sorry we only have  " + staging.getProductQuantity() + " in stock.");
        }

    }

    public void deleteProduct(int index) {
        index = index - 1;
        inventory.remove(index);
        System.out.println("Done. Updated list:\n");
        getInventory();
    }

    
    //TO STRING METHOD

    @Override
    public String toString() {
        return "Product [ name=" + Productname + " | price=" + Productprice + " | quantity=" + quantity + " ]";
    }

    public String getProductdescription() {
        return this.Productdescription;
    }

    public String getSize() {
        return null;
    }

}
