package shop;

import java.util.ArrayList;

import shop.model.Product;

public class App {
    
    public static void main(String[] args) {
     //Not sure if relevant but Collection
      Product seeinventory= new Product();
    
      new Product("Nike slides",34.99,8, "blue/white");
      new Product("Nike slidez",34.99,8, "black/white");
      new Product("Nike shoes",60.99,16, "white");
      new Product("Nike shoes", 60.99, 16,  "black");
      new Product("Benzzys",34.99,8, "black/white");
      seeinventory.getInventory("Benzzys");
      
    
    }
    
}
