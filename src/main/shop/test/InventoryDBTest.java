package shop.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        //Create User
        createUser("Sam", "Grant");   
        createUser("Bruce", "Banner"); 

        // Read Db
        readUsers();

        //Update User
        updateUser("Luke", "Bob");
        
        //Delete Useer
        deleteUser("Luke");
       
        //I should covert the inventory to a a data structure, have sorted then added.
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
