/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents the Beverage Shop 
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BevShop implements BevShopInterface {
    private int numOfAlcoholDrinksInCurrentOrder;
    private List<Order> orders;

    public BevShop() {
        this.numOfAlcoholDrinksInCurrentOrder = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinksInCurrentOrder < getMaxOrderForAlcohol();
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinksInCurrentOrder;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order newOrder = new Order(generateOrderNumber(), time, day, new Customer(customerName, customerAge));
        orders.add(newOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        addNewBeverage(coffee);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            Beverage alcohol = new Alcohol(bevName, size, false);
            addNewBeverage(alcohol);
            numOfAlcoholDrinksInCurrentOrder++;
        } else {
            System.out.println("You have reached the maximum number of alcohol drinks for this order.");
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (!isMaxFruit(numOfFruits)) {
            Beverage smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
            addNewBeverage(smoothie);
        } else {
            System.out.println("You reached the maximum number of fruits.");
        }
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcPrice();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        return orders.stream().mapToDouble(Order::calcPrice).sum();
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        } else {
            System.out.println("No current order.");
            return null;
        }
    }
    @Override
    public Order getOrderAtIndex(int index) {
        return (index >= 0 && index < orders.size()) ? orders.get(index) : null;
    }

    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }

    private void addNewBeverage(Beverage beverage) {
        Order currentOrder = getCurrentOrder();
        if (currentOrder != null) {
            currentOrder.addNewBeverage(beverage);
        } 
    }

    private int generateOrderNumber() {
        return (int) (Math.random() * 90000) + 10000;
    }
}
