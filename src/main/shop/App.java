package shop;

import java.util.ArrayList;
import java.util.Scanner;

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
      seeinventory.getInventory();

      //Scann inventory
      Scanner scannerProd = new Scanner(System.in);
        System.out.print("Which product would you like to add to cart # ");
        int itemNum = scannerProd.nextInt();
        seeinventory.getInventory(itemNum);

        // Scanner scannerQ = new Scanner(System.in);
        System.out.print("How many would you like to buy # "); //would you like to add
        int itemQuan=scannerProd.nextInt();
        seeinventory.updateQuantity(itemNum, itemQuan);
    
    }
    
}
