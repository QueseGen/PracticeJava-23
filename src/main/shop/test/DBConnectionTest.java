package shop.test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    
    public static void main(String[] args) {
        System.out.println("Here");
        try {
            Connection connection = InventoryDBTest.getConnection();
            if (connection != null) {
                System.out.println("Yessir!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
            e.printStackTrace();
        }
        
    }
}
