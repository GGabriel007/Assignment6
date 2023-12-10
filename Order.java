/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents an Order
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int time;
    private Day day;
    private Customer customer;
    private List<Beverage> beverages;

    // Constructor
    public Order(int orderNumber, int time, Day day, Customer customer) {
        this.orderNumber = orderNumber;
        this.time = time;
        this.day = day;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    public Order(int orderNumber, Day day, Customer customer) {
    	this.orderNumber = orderNumber;
    	this.day = day;
    	this.customer = customer;
    	this.beverages = new ArrayList<>();
	}

	@Override
    public boolean isWeekend() {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        return (itemNo >= 0 && itemNo < beverages.size()) ? beverages.get(itemNo) : null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        addNewBeverage(coffee);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        Beverage alcohol = new Alcohol(bevName, size, false);
        addNewBeverage(alcohol);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Beverage smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        addNewBeverage(smoothie);
    }

    public double calcOrderTotal() {
        double total = beverages.stream().mapToDouble(Beverage::calcPrice).sum();
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        return (int) beverages.stream().filter(beverage -> beverage.getType() == type).count();
    }

    @Override
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(this.time, otherOrder.time);
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    

    public double calcPrice() {
        double totalPrice = 0.0;
        for (Beverage beverage : beverages) {
            totalPrice += beverage.calcPrice();
        }
        return totalPrice;
    }
    
    public int getTotalItems() {
    	return beverages.size();
    }


    // Other methods, getters, and setters as needed
}
