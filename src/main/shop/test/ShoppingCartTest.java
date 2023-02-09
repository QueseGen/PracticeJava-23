package shop.test;

import java.util.ArrayList;

import shop.model.Product;
import shop.model.User;

public class ShoppingCartTest {

    public static void main(String[] args) {
        System.out.println("\n1. Create inventory/database");//1. Create inventory/database
        Product seeinventory= new Product();

        System.out.println("\n2. Create user");//2. Create user
        User admin= new User("Admin","test123");

        System.out.println("\n3. Add products to inventory");//3. Add products to inventory
        new Product("Nike slides", 34.99, 8, "red/white");
        new Product("Crocs", 34.99, 8, "white");
        new Product("Steppers", 34.99, 10, "black");
        new Product("Air Force Ones", 120.99, 16, "white");
        new Product("Nike shoes", 60.99, 16, "blue/white");
        new Product("Benzzy Airs", 34.99, 8, "black/white");

       System.out.println("\n4. Display inventory"); //4. Display inventory
        seeinventory.getInventory();

        System.out.println("\n5. Open Shopping cart:");//5. Open Shopping cart
        admin.openShoppingCart();

       System.out.println("\n6. Add to shopping cart"); //6. Add to shopping cart        
        admin.getPendingOrder().addItem(2, 7);
        admin.getPendingOrder().addItem(3, 5);

        System.out.println("\n7. Show Current shopping Cart:");//7. Show Current shopping Cart
        admin.getPendingOrder().printItems();

        System.out.println("\n8. Update/Delete quantity in Shopping cart");//8. Update quantity in Shopping cart
        admin.getPendingOrder().updateItem(2, 2); //addItem is better than updateItem
        admin.getPendingOrder().printItems();

        System.out.println("\n9. add duplicates in Shopping cart");// 8. Update quantity in Shopping cart
        seeinventory.getInventory();
        admin.getPendingOrder().addItem(2, 4);
        admin.getPendingOrder().addItem(3, 2);
        admin.getPendingOrder().addItem(4, 8);
        admin.getPendingOrder().printItems();
        
        System.out.println("\n10. remove item from  in Shopping cart");// 8. Update quantity in Shopping cart
        admin.getPendingOrder().addItem(3, 0);
        
        admin.getPendingOrder().printItems();

       // admin.getPendingOrder().checkout();
       // seeinventory.getInventory();
    }
}
