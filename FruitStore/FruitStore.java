import java.util.Scanner;
import java.util.Arrays;


public class FruitStore{
    public static void main(String[] args) {

        String[][] products = new String[2][6];
        products[0][0] = "1"; products[1][0] = "Oranges";
        products[0][1] = "2"; products[1][1] = "Tomatoes";
        products[0][2] = "3"; products[1][2] = "Cucumber";
        products[0][3] = "4"; products[1][3] = "Carrot";
        products[0][4] = "5"; products[1][4] = "Potatoes";
        products[0][5] = "6"; products[1][5] = "Apples";

        
        
        System.out.println("|----> Fruit Store <----|");
        logIn();
        boolean confirm = false;
        while(!confirm){
            confirm = selectOrder(products);
        }
        System.out.println("Your order will be processed. \nThanks for your purchase.");
        
    }

    /**
     * Descripción: Validates log in from a array with usernames and passwords.
     * @author Victor-Oviedo
     * @return isLoggedIn: boolean that determinates if is logged in or is a guest. 
     */ 
    public static boolean logIn() {

        boolean isLoggedIn = false;
        var selectLogIn = 0;
        Scanner sc = new Scanner(System.in);
        String username = "xxxxx";
        String password = "xxxxx";
        String[][] matchUserPass = new String [3][2];

        //Registered users:
        matchUserPass[0][0] = "victor.oviedo"; matchUserPass[0][1] = "1234";
        matchUserPass[1][0] = "julio.cortazar"; matchUserPass[1][1] = "cronopio3";
        matchUserPass[2][0] = "max.planck"; matchUserPass[2][1] = "planck-ton";
        
        //log in or guest decision
        do{
            try {
                System.out.println("1. Log in \n2. Enter as a guest");
                selectLogIn = Integer.valueOf(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Please, enter a valid option");
                }
            } 
            while(selectLogIn != 1 && selectLogIn != 2);
            isLoggedIn = (selectLogIn == 1)?true:false;


        if(!isLoggedIn){
            System.out.println("Welcome, guest!");
            return isLoggedIn;
        }
        //log in validation
        else{
            isLoggedIn = false;
            while(!isLoggedIn){
                System.out.println("Please, enter username: ");
                System.out.println("Hint: user: victor.oviedo pass: 1234");
                username = String.valueOf(sc.nextLine());
                System.out.println("Please, enter pasword: ");
                password = String.valueOf(sc.nextLine());

                //validation
                for (int i = 0; i < matchUserPass.length; i++) {
                        if(username.equals(matchUserPass[i][0])){
                            for (int j = 0; j < matchUserPass[i].length; j++) {
                                isLoggedIn = (password.equals(matchUserPass[i][j]))?true:false;
                            }
                        }

                    }
            }

            System.out.println("Welcome, "+username);
            return isLoggedIn;
        }
    }


        /**
     * Descripción: Shows options and validates order from user. 
     * @author Victor-Oviedo
     * @param products: List of products to select order. 
     * @return true if the order is confirmed, otherwise false. 
     */
    public static boolean selectOrder(String[][] products) {
        for (int i = 0; i < products[0].length; i++) {
                System.out.println(products[0][i] + " - " + products[1][i]);
        }        

        Scanner sc = new Scanner(System.in);
        boolean orderConfirmed = false;
        String pickedElement = "0";
        double[][] order =  new double[2][20];
        double amount = 1.0;
        String confirm = "0";

        //select order
        while(!orderConfirmed){
            System.out.println("Select a product or 0 to finish");
            pickedElement = String.valueOf(sc.nextLine());

            orderConfirmed = pickedElement.equals("0")?true:false;

            for (int i = 0; i < products[0].length; i++) {
                if(pickedElement.equals(products[0][i])){
                    System.out.println("How much Kg of "+products[1][i]);

                    try{
                        amount = Double.valueOf(sc.nextLine());
                        int index = Integer.parseInt(pickedElement);
                        index = index - 1;
                        order[0][index] = index; 
                        order[1][index] = amount;
                    } catch (Exception e) {
                        System.out.println("Please, enter a valid amount");
                        }

                }
            }

        }
        System.out.println("****************************");
        System.out.println("Your order is: ");
        System.out.println("----------------------------");
        for (int i = 0; i < products[0].length; i++) {
            System.out.println(products[1][i] + ":      " + order[1][i] + " Kg");
        }
        System.err.println("****************************");
        System.out.println("Enter 0 to change your order or anything to confirm");
        confirm = String.valueOf(sc.nextLine());

        if(confirm.equals("0")){
            return false;
        } else return true;
    }

}