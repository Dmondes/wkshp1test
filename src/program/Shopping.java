package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList <String> shoppingCart = new ArrayList<>();
        System.out.println("Welcome to your shopping cart ");
        while (true){
        String input = scan.nextLine();
        String removeComma = input.replace(",", "");
        String [] parts = removeComma.split(" ");
        if (parts[0].equals("quit")){
            break;
        }
        switch (parts[0]) {
            case "list":
            if (shoppingCart.size() == 0){
                System.out.println("Your cart is empty");
            }
            for (int i = 1; i <= shoppingCart.size(); i ++){
                System.out.println(i + ". "+ shoppingCart.get(i - 1));
            }
                break;
            case "add":
            boolean exist = false;
            for (int i = 1; i < parts.length; i ++){
                for (String item: shoppingCart){
                    if (item.equals(parts[i].toLowerCase())){
                        System.out.println("Item already in cart");
                        exist = true;
                        break;
                    }
                }
                if (exist == false){
                shoppingCart.add(parts[i].toLowerCase());
                System.out.println(shoppingCart.get(shoppingCart.size() - 1) + " added to cart");
                }
            }
            break;
            case "delete":
            int index = Integer.parseInt(parts[1]);
            if (index >= shoppingCart.size()){
                System.out.println("index out of bounds");
                break;
            }
            String removed = shoppingCart.get(index);
            shoppingCart.remove(index);
            System.out.println(removed + " removed from cart");
            break;
            default:
            System.out.println("Command not found");
                break;
        }
    }
    }
}
