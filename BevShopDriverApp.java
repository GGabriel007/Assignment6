/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents the Beverage Shop Driver App
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a BevShop instance
        BevShop bevShop = new BevShop();

        // First customer
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() +
                " alcoholic beverages.");
        System.out.println("The minimum age to order an alcohol drink is " + bevShop.getMinAgeForAlcohol());

        System.out.println("Start a new order:");
        System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(1));
        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int age = scanner.nextInt();

        bevShop.startNewOrder(12, Day.MONDAY, name, age);

        if (bevShop.isValidAge(age)) {
            System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol.");

            // Adding alcohol drinks
            bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
            bevShop.processAlcoholOrder("Wine", Size.LARGE);

            // Adding a coffee
            bevShop.processCoffeeOrder("Latte", Size.LARGE, true, false);

            System.out.println("#------------------------------------#");
        } else {
            System.out.println("Your age is not appropriate for an alcohol drink!!");
        }

        // Second customer
        System.out.println("Would you please start a new order");
        System.out.print("Would you please enter your name: ");
        scanner.nextLine(); // consume the newline character
        name = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        age = scanner.nextInt();

        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(2));

        bevShop.startNewOrder(15, Day.SATURDAY, name, age);

        // Adding smoothies and coffee
        bevShop.processSmoothieOrder("Berry Blast", Size.SMALL, 5, true);
        bevShop.processSmoothieOrder("Tropical Paradise", Size.MEDIUM, 3, false);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);

        // Adding an alcohol drink (should not be allowed due to age)
        bevShop.processAlcoholOrder("Vodka", Size.LARGE);

        System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(2));
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());

        scanner.close();
    }
}
