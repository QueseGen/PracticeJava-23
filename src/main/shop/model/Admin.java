package shop.model;

    public class Admin extends User {

        public Admin(String name, String password) {
            super(name, password);
            // TODO Auto-generated constructor stub
        }

        public void Ops(String operation, Product pro) {
            switch (operation) {
                case "read":
                    Product.getInventory();
                    break;
                case "add":
                    Product.IventoryList().add(pro);
                    break;
                case "alt":
                    Product.getInventory();
                    // get product index
                    break;
                case "del":
                    Product.getInventory();
                    // get product index
                    Product.IventoryList().remove(pro);
                    break;

            }
        }

    }