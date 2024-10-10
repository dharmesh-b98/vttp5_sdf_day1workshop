package src;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart1 {
    
    public void menu(){
        System.out.println("Welcome to your shopping cart.");
        System.out.println("Enter \"list\" to view your shopping cart");
        System.out.println("Enter \"add<space><name of item1>,<name of item2>,... \" to add items into your shopping cart");
        System.out.println("Enter \"remove<space><name of item>\" to remove item from shopping cart");
        System.out.println("Enter \"quit\" to leave the program");
    }

    public void startProgram(){
        
        Map<String,Integer> cart = new HashMap<>();

        Console cons = System.console();
        String keyboardInput = cons.readLine(">>").trim().toLowerCase();

        while (!(keyboardInput.equals("quit"))){
            if (keyboardInput.equals("list")){
                if (cart.isEmpty()){
                    System.out.println("Cart is empty");
                }
                else{
                    System.out.println("Item :  No of Items");
                    for(String key: cart.keySet()){
                        System.out.printf("%s : %d \n", key,cart.get(key));
                    }
                }
                
            }

            else if (keyboardInput.startsWith("add")){
                Scanner scan = new Scanner(keyboardInput.substring(4));
                scan = scan.useDelimiter(",");
                while (scan.hasNext()){
                    String item = scan.next();
                    if (cart.containsKey(item)){
                        cart.replace(item,cart.get(item)+1);
                    }
                    else{
                        cart.put(item,1);
                    }
                }
            }

            else if (keyboardInput.startsWith("remove")){
                Scanner scan = new Scanner(keyboardInput.substring(7));
                scan = scan.useDelimiter(",");
                while (scan.hasNext()){
                    String item = scan.next();
                    if (cart.containsKey(item)){
                        cart.replace(item,cart.get(item)-1);

                        if (cart.get(item) == 0){
                            cart.remove(item);
                        }
                    }

                    else{
                        System.out.printf("%s does not exist in cart");
                    }
                }
                
                
            }
            
            else{
                System.out.println("Invalid Input");
                menu();
            }

            keyboardInput = cons.readLine(">>").trim().toLowerCase();
        }
    }

    public static void main (String[] args){
        ShoppingCart1 shoppingcart1 = new ShoppingCart1();
        shoppingcart1.menu();
        shoppingcart1.startProgram();        
    }
    
}
