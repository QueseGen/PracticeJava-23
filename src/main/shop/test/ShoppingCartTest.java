package shop.test;

import java.util.ArrayList;

import shop.model.Product;
import shop.model.User;

public class ShoppingCartTest {

    public static void main(String[] args) {
        //1. Create inventory/database
        Product seeinventory= new Product();

        //2. Create user
        User admin= new User("Admin","test123");

        //3. Add products to inventory
        new Product("Nike slides", 34.99, 8, "red/white");
        new Product("Crocs", 34.99, 8, "white");
        new Product("Steppers", 34.99, 10, "black");
        new Product("Air Force Ones", 120.99, 16, "white");
        new Product("Nike shoes", 60.99, 16, "blue/white");
        new Product("Benzzy Airs", 34.99, 8, "black/white");

        //4. Display inventory
        seeinventory.getInventory();

        //5. Open Shopping cart
        admin.openShoppingCart();

        //6. Add to shopping cart        
        admin.getPendingOrder().addItem(2, 7);
        admin.getPendingOrder().addItem(3, 5);

        admin.getPendingOrder().checkout();
    }
}
