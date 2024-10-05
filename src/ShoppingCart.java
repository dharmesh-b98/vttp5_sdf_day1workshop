package src;
import java.io.*;
import java.util.*;

public class ShoppingCart{


    public void menu(){
        System.out.println("Welcome to your shopping cart");
        System.out.println("Inputs");
        System.out.println("list: List the contents of the cart");
        System.out.println("add: Add one or more items to the cart");
        System.out.println("delete: Delete an item from the cart based on its index");
        System.out.println("quit: Quit the app");
    }

    public void startprogram(){
        List<String> shoppingCart = new ArrayList<>();
        Console console = System.console();
        String keyboardInput = " ";
        menu();
        while (!keyboardInput.equals("quit")){
            System.out.println(">>");
            keyboardInput = console.readLine();

            if (keyboardInput.equals("list")){
                if (shoppingCart.size() == 0){
                    System.out.println("Your cart is empty");
                }
                else{
                    System.out.println("Shopping Cart");
                    for (String item: shoppingCart){
                        System.out.println(item);
                    }
                }

            }

            else if(keyboardInput.startsWith("add")){
                Scanner scanner1 = new Scanner(keyboardInput.substring(4));
                while (scanner1.hasNext()){
                    String item = scanner1.useDelimiter(",").next().toLowerCase();
                    if (shoppingCart.contains(item)){
                        System.out.println(item + " already in shopping list");
                    }
                    else {
                        shoppingCart.add(item);
                    }   
                }
                scanner1.close();
            }

            else if (keyboardInput.startsWith("delete")){
                Scanner scanner2 = new Scanner(keyboardInput.substring(7));
                Integer index = Integer.parseInt(scanner2.next());
                shoppingCart.remove((int) index);
                scanner2.close();
            }
            
        }

    }

    public static void main (String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.startprogram();
    }
}