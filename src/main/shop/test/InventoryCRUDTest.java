package shop.test;

import java.util.Scanner;

import shop.model.Product;

public class InventoryCRUDTest {

    public static void main(String[] args) throws InterruptedException {
        // Not sure if relevant but Collection
        Product seeinventory = new Product();

        //Create
        new Product("Nike slides", 34.99, 8, "red/white");
        new Product("Crocs", 34.99, 8, "white");
        new Product("Steppers", 34.99, 10, "black");
        new Product("Air Force Ones", 120.99, 16, "white");
        new Product("Nike shoes", 60.99, 16, "blue/white");
        new Product("Benzzy Airs", 34.99, 8, "black/white");

        //Read
        seeinventory.getInventory();
        
       
        Scanner scannerTest = new Scanner(System.in);
        System.out.print("Which product would you like to add to cart # ");
        int itemNum = scannerTest.nextInt();
        seeinventory.getInventory(itemNum);

        //Update
        System.out.print("How many would you like to buy # "); // would you like to add
        int itemQuan = scannerTest.nextInt();
        seeinventory.updateQuantity(itemNum, itemQuan);

        //Delete
        System.out.println("If you can delete one item what would it be?");
        Thread.sleep(3000);
        seeinventory.getInventory();
        System.out.print("# ");
        itemNum = scannerTest.nextInt();
        seeinventory.deleteProduct(itemNum);

        scannerTest.close();

    }

}
