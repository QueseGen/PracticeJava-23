
Tasks

1. Create a new class for a shopping Cart
    ShoppingCart Class - PracticeJava-23/src/main/shop/model/ShoppingCart.java
2 We got following fields in ShoppingCart Class:
    private float SubTotal;
    private float Total;
    private final float SaleTax= .10;
     private int quanity;
    private String shoppingCartName;

3. ShoppingCart class has four CRUDS methods that control:
    Update- updatecart() or updateItem depending on if ShoppingCart Item or Item needs to be removed from Iventory.
    Add-Within AddItem() or through updatecart()
    Deletions-through updatecart() or deleteProduct()

4. getSubtotal(), getTaxes(), getTotal() in PracticeJava-23/src/main/shop/model/ShoppingCart.java
5. Product Class at PracticeJava-23/src/main/shop/model/Product.java
6. App.java is entry point for Application located in PracticeJava-23/src/main/shop/view/App.java
    Warehouse and Admin classes in PracticeJava-23/src/main/shop/model/ folder

7. Add Inventorydb

CREATE DATABASE IF NOT EXISTS inventorydb;
USE inventorydb;
 
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  ID int(11) NOT NULL AUTO_INCREMENT,
  BOOl
  NAME varchar(50) DEFAULT NULL,
  PWD varchar(25) DEFAULT NULL,
  PRIMARY KEY (NAME)
) ENGINE=InnoDB AUTO_INCREMENT=4;
 
 
INSERT INTO users (ID,NAME,AGE,CITY) VALUES 
 (1,'Ram Kumar',25,'Salem'),
 (2,'Sam Kumar',25,'Salem'),
 (3,'Rakesh',25,'Salem');
 
