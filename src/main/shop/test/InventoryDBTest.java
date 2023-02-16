package shop.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import shop.model.Product;

public class InventoryDBTest {

    private static Properties properties = null;
    private static Connection connection = null;
    private static final String DB_DRIVER="db.Class.forName";
    private static final String DB_USER = "db.username";
    private static final String DB_PWD = "db.password";
    private static final String DB_URL = "db.url";
    private static final String DB_SERVER = "db.server";
    private static final String DB_NAME = "db.name";

    static{
        try {
            properties = new Properties();
            properties.load(new FileInputStream(".vscode/connection.properties"));
            Class.forName(properties.getProperty(DB_DRIVER));
            connection=DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USER), properties.getProperty(DB_PWD));
        } catch (SQLException | ClassNotFoundException | IOException e) {
           e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void main(String[] args) throws InterruptedException, SQLException {

        Connection con=getConnection();
        Statement statement = getConnection().createStatement();
        ResultSet rs;
        PreparedStatement st;
        String qry="";

    //User CRUD
        //createUser("Sam", "Grant");   
        //createUser("Bruce", "Banner"); 
        //updateUser("Sam", "Quese");
        //readUsers();
        //deleteUser("Luke");

    // Product CRUD
        createProduct("Nike slide", 34.99f, 8, "Slides are sleek and simple — a great footwear option for simple errands, lounging with friends, hitting the beach or doing absolutely nothing. Nike slides are made with durable materials for \ttraction and support so your feet feel effortlessly secure, wherever your chill day takes you.");
        createProduct("Croc", 34.99f, 8, "Crocs, Inc., is a Colorado maker of unique clogs that became extremely popular in the early 2000s with both men and women. The inexpensive shoes rely on a proprietary closed-cell resin material called Croslite to produce a lightweight, slip-resistant, odor-resistant, non-marking sole.");
        readProducts();
        //updateProduct("Nike slides"," ");
        deleteProduct("Crocs");
       
    //Inventory CRUD
        //
        //I should covert the inventory to a a data structure, have sorted then added.
    }

    private static void createProduct(String getProductname, float getProductprice, int getProductquantity,String getProductdescription) {
        String qry = "insert into products (NAME, PRICE, QUANTITY, DESCRIPTION) values(?,?,?,?)";

        try {
            PreparedStatement st = getConnection().prepareStatement(qry);
            st.setString(1, getProductname);
            st.setFloat(2, getProductprice);
            st.setInt(3, getProductquantity);
            st.setString(4, getProductdescription);
            st.executeUpdate();

            System.out.println("Data Insert Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static void readProducts() throws SQLException {
        ResultSet rs = null;

        String qry = "SELECT ID, NAME, PRICE, QUANTITY, DESCRIPTION from products";

        try {
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery(qry);

            System.out.println("Data Retrived Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            System.out.print(rs.getInt("ID") + " ");
            System.out.print(rs.getString("NAME") + " ");
            System.out.print(rs.getFloat("PRICE") + " ");
            System.out.print(rs.getInt("QUANTITY") + " ");
            System.out.println(rs.getString("DESCRIPTION"));
        }
    }

    private static void updateProduct(String string, String string2) {
    }

    private static void deleteProduct(String getProductname) throws SQLException {
        String qry = "delete from products where NAME=?";
        PreparedStatement st = getConnection().prepareStatement(qry);
        st.setString(1, getProductname);

        st.executeUpdate();
    }
    
    public static String createUser(String getUsername, String getPwd){

        String qry = "insert into users (USERNAME,PWD) values(?,?)";

        try {
            PreparedStatement st = getConnection().prepareStatement(qry);
            st.setString(1, getUsername);
            st.setString(2, getPwd);
            st.executeUpdate();

            return "Data Insert Success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public static void readUsers() throws SQLException {
        ResultSet rs=null;
        
        String qry="SELECT ID, USERNAME from users";
        
        try {
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery(qry);
       
            System.out.println("Data Retrived Success");
        } catch (Exception e) { e.printStackTrace(); }
        while (rs.next()) {
            System.out.print(rs.getInt("ID") + " ");
            System.out.println(rs.getString("USERNAME") );}
        }
    public static void updateUser(String getNewUsername, String getOldUsername) throws SQLException {
        String qry = "update users set USERNAME=? where USERNAME=?";
        PreparedStatement st = getConnection().prepareStatement(qry);

        st.setString(1, getNewUsername);
        st.setString(2, getOldUsername);
        st.executeUpdate();
        System.out.println("Data Update Success");
    }

    private static void deleteUser(String getUsername) throws SQLException {
        String qry = "delete from users where USERNAME=?";
        PreparedStatement st = getConnection().prepareStatement(qry);
        st.setString(1, getUsername);

        st.executeUpdate();
    }
    }
